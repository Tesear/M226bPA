import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewGame implements ActionListener {

    // Alle Private Variabeln werden Initialisiert
    private final JFrame frame;
    private JPanel panel;
    private JTextField name_feld;
    private JTextField att_feld;
    private JTextField descr_feld;
    private JButton addGameButton;
    private JButton homeButton;
    private JLabel titel;
    private final ArrayList<ArrayList<String>> all;
    private final ArrayList<Integer> favs;

    // Erstellt ein neues Spiel
    NewGame(Point ort, Dimension gross, ArrayList<ArrayList<String>> arrayList, ArrayList<Integer> favs){

        // Eröffnet das Fenster für das Hinzufügen eines neuen Spiels
        frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(ort);
        frame.setSize(gross);
        frame.add(panel);

        this.all = arrayList;
        this.favs = favs;

        // Setzt Font und Grösse für die Ausgabe in der Tabelle
        Font titel = new Font("Arial", Font.BOLD, 20);
        this.titel.setFont(titel);

        // Fügt ein Zurück-Knopf und der AddGameButton zu
        addGameButton.addActionListener(this);
        homeButton.addActionListener(this);
    }

    // Liest die Eingaben aus
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addGameButton){
            String name = name_feld.getText();
            String att = att_feld.getText();
            String descr = descr_feld.getText();

            // Das Programm fährt nicht fort, bis alle Felder ausgefüllt sind
            if (!name.isEmpty() && !att.isEmpty() && !descr.isEmpty()){
                frame.dispose();
                new HomePanel(frame.getLocation(), frame.getSize(), name, att, descr, all, favs, 0);
            }
        }
        // Öffnet wieder das Home-Fenster
        if (e.getSource() == homeButton){
            frame.dispose();
            new HomePanel(frame.getLocation(), frame.getSize(), "", "", "", all, favs, 0);
        }
    }
}