import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {                                        // Führt main aus
        ArrayList<Integer> favs = new ArrayList<>();                                // Erstellt ArrayList für die Favoriten
        ArrayList<ArrayList<String>> all = new ArrayList<>();                       // Erstellt ArrayList für alles
        new Standard(all);
        Point ort = new Point(0, 0);                                          // Zentriert das Fenster
        Dimension gross = new Dimension(500, 500);                      // Setzt die Fenstergrösse
        new HomePanel(ort, gross, "","","", all, favs, 1);      // Öffnet das erste HomePanel
    }
}
