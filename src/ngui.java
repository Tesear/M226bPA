import javax.swing.*;
import java.awt.*;

public class ngui {
    private JPanel panel1;
    private JTable table1;

    ngui(){
        JFrame frame = new JFrame();
        frame.setTitle("Pup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}
