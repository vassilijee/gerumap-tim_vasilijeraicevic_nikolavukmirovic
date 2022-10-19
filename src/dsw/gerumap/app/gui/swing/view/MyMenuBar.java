package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {

        JMenu file = new JMenu("File");
        JMenuItem miNew = new JMenuItem("New");

        JMenu help = new JMenu("Help");
        JMenuItem miEdit = new JMenuItem("Edit");

        file.add(miNew);
        help.add(miEdit);

        add(file);
        add(help);
    }
}
