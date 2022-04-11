import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;


public class HomePanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -2308580586819935012L;

    JLabel title = new JLabel("Game-Library");
    JButton addButton = new JButton("Add Game");
    JButton removeButton = new JButton("Remove Game");
    JButton editButton = new JButton("Edit Game");

    String[] header = { "Name", "Description", "Attributs" };

    SimpleGameManager s = new SimpleGameManager();


    HomePanel() {
        List<String> at = new ArrayList<String>();
        at.add("Test0");
        s.addGame("Terraria", at, "Sandbox Based game");

        JTable table = new JTable(d(s.getGames()), header);

        title.setFont(new Font("Calibri", Font.BOLD, 40));
        table.setSize(new Dimension(800, 700));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setWidth(100);

        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(100);

        JScrollPane pane = new JScrollPane(table);

        this.add(title);
        this.add(addButton);
        this.add(removeButton);
        this.add(editButton);
        this.add(pane);
    }


    private String[][] d(List<SimpleGame> games) {
        String[][] table = new String[games.size()][3];

        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
            table[i][0] = games.get(i).getName();
            table[i][1] = games.get(i).getDescription();
            String attributsString = games.get(i).getAttributs().stream().map(n -> String.valueOf(n))
                    .collect(Collectors.joining("-", "{", "}"));

            table[i][2] = attributsString;
        }

        return table;
    }

    public void repaintPanel() {
        this.repaint();
    }
}