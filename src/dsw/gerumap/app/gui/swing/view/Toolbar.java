package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {
    public Toolbar() {
        //u konstruktor nadklase, tj klse JToolbar prosleđuje
        //se orijentacija toolbar-a, moguća i sa konstantom: SwingConstants.VERTICAL

        super(SwingConstants.HORIZONTAL);
        JButton btnNew = new JButton();
        btnNew.setToolTipText("New");
        btnNew.setIcon(new ImageIcon("src/dsw/gerumap/app/swing/controller/images/new.jpg"));
        add(btnNew);

        setBackground(new Color(174, 182, 191));

    }
}
