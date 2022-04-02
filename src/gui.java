import javax.swing.*;
import java.awt.*;

public class gui {
    gui(){
        JFrame frame = new JFrame();
        frame.setTitle("Pup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setVisible(true);
    }
}