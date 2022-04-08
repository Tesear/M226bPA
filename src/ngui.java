import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ngui {
    private JPanel panel1;
    private JTable table1;

    ngui(){
        JFrame frame = new JFrame();
        frame.setTitle("GameList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        list();
    }
    public void list(){
        ArrayList<ArrayList> array_double = new ArrayList();
        Object[][] arrr = new Object[0][];
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM GAMELists");
            /*while (resultSet.next()){
                System.out.println(resultSet.getString("Name"));
            }*/
        }
        catch (SQLException ex){
            System.out.print("failed", ex);
        }
        Object[][] inhalt = {{"Minecraft1", "Elon Musk", "2001"}, {"Minecraft 2", "Beff Jezos", "2002"}};
        table1.setModel(new DefaultTableModel(inhalt, new String[]{"Name", "Publisher", "Jahr"}));
    }
}
