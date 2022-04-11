import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePanel implements ActionListener {

    // Initialisiert alle Variabeln
    private final JFrame frame;
    private JTable table;
    DefaultTableModel tableModel = new DefaultTableModel();
    private JPanel panel;
    private JButton addGameButton;
    private JButton deleteGameButton;
    private JButton favoriteButton;
    private JButton favoritesListButton;
    private JLabel titel;
    private final ArrayList<ArrayList<String>> all;
    private final ArrayList<Integer> favs;

    // Erstellt das Home Panel
    HomePanel(Point ort, Dimension gross, String name, String att, String descr, ArrayList<ArrayList<String>> arrayList, ArrayList<Integer> favs, int full){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(ort);
        frame.setSize(gross);

        // Sorgt, dass das Fenster nach bei Knopfdruck nicht wieder mittig gesetzt wird
        if (full == 1){
            frame.setLocationRelativeTo(null);
        }

        frame.add(panel);

        this.all = arrayList;
        this.favs = favs;

        table.getTableHeader().setReorderingAllowed(false);

        Font titel = new Font("Arial", Font.BOLD, 20);
        this.titel.setFont(titel);

        // Buttons erhalten jeweils einen ActionListener
        addGameButton.addActionListener(this);
        deleteGameButton.addActionListener(this);
        favoriteButton.addActionListener(this);
        favoritesListButton.addActionListener(this);

        // Die Spaltennamen werden gesetzt
        tableModel.addColumn("Name");
        tableModel.addColumn("Attributs");
        tableModel.addColumn("Description");

        // Ladet die Daten eines neuen Spieles in die Tabelle
        if (!name.isEmpty() && !att.isEmpty() && !descr.isEmpty()){
            ArrayList<String> data = new ArrayList<>();
            data.add(name);
            data.add(att);
            data.add(descr);
            all.add(data);
        }

        // Fügt alle Daten in die Tabelle
        for (ArrayList<String> strings : this.all) {
            ArrayList<String> mysarr;
            mysarr = strings;
            tableModel.addRow(mysarr.toArray());
        }
        table.setModel(tableModel);
    }

    // Ladet das Insgesamte Panel
    @Override
    public void actionPerformed(ActionEvent e) {

        // Fügt den addGameButton hinzu
        if (e.getSource() == addGameButton){
            frame.dispose();
            new NewGame(frame.getLocation(), frame.getSize(), all, favs);
        }

        // Fügt den deleteGameButton hinzu
        if (e.getSource() == deleteGameButton){
            if (table.getSelectedRow() != -1){
                int index = table.getSelectedRow();
                tableModel.removeRow(index);
                all.remove(index);
            }
        }

        // Fügt die Funktion für den favoriteButton hinzu
        if (e.getSource() == favoriteButton){
            int index = table.getSelectedRow();
            int deu = 0;
            // Prüft, ob das Spiel schon in den Favoriten ist
            for (int i : favs){
                if (i == index) {
                    deu = 1;
                    break;
                }
            }
            if (deu == 0){
                favs.add(index);
            }
        }
        // Wenn ein Favorite gesetzt wird, ladet es die Favorite List
        if (e.getSource() == favoritesListButton){
            frame.dispose();
            new Favorites(favs, all, frame.getLocation(), frame.getSize());
        }
    }
}