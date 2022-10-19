package dsw.gerumap.app.swing.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        setSize(300, 200);
        setTitle("GUI");
        setBackground(new Color(93, 109, 126));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // menu
        MyMenuBar menu=new MyMenuBar();
        this.setJMenuBar(menu);

        // toolbar
        Toolbar toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
    }
}
