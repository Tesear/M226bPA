import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Favorites implements ActionListener {

    // Initialisiert alle Variabeln
    private final JFrame frame;
    private JPanel panel;
    private JLabel titel;
    private JTable table;
    DefaultTableModel tableModel = new DefaultTableModel();
    private JButton homeButton;
    private JButton removeButton;
    private final ArrayList<ArrayList<String>> all;
    private final ArrayList<Integer> favs;

    // Setzt das Programmfenster
    Favorites(ArrayList<Integer> favs, ArrayList<ArrayList<String>> arrayList, Point ort, Dimension gross){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(ort);
        frame.setSize(gross);
        frame.add(panel);

        this.all = arrayList;
        this.favs = favs;

        // Fixiert die Tabelleninhalte
        table.getTableHeader().setReorderingAllowed(false);

        // Ladet die Fonts
        Font titel = new Font("Arial", Font.BOLD, 20);
        this.titel.setFont(titel);

        homeButton.addActionListener(this);
        removeButton.addActionListener(this);

        // Die Spalten werden gesetzt
        tableModel.addColumn("Name");
        tableModel.addColumn("Attributs");
        tableModel.addColumn("Description");

        // Ladet alle Daten in die Tabelle
        for (int i = 0; this.all.size()> i; i++){
            ArrayList<String> mysarr;
            mysarr=this.all.get(i);
            for (int j : favs){
                if (j == i){
                    tableModel.addRow(mysarr.toArray());
                }
            }
        }
        table.setModel(tableModel);
    }

    // Der Home-Knopf wird gesetzt
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton){
            frame.dispose();
            new HomePanel(frame.getLocation(), frame.getSize(), "", "", "", all, favs, 0);
        }
        // Der removeButton wird gesetzt
        if (e.getSource() == removeButton){
            if (table.getSelectedRow() != -1){
                int index = table.getSelectedRow();
                tableModel.removeRow(index);
                favs.remove(index);
            }
        }
    }
}