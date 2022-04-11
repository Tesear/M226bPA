import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Frame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6520390117170880441L;

    HomePanel homePanel;
    EditorPanel editorPanel;

    public Frame() {
        homePanel = new HomePanel();
        editorPanel = new EditorPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 400));
        this.setTitle("Game-Library");



        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("Editor", editorPanel);

        this.add(tabbedPane);
        this.pack();

        this.setLocationRelativeTo(null);

        this.setVisible(true);

    }

    public void paint() {
        homePanel.repaintPanel();
    }

}