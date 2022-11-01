package dsw.gerumap.app.gui.swing.view.tab;

import javax.swing.*;
import java.awt.*;

public class SelectCoursePanel extends JFrame {
    JCheckBox java, swing, hibernate;

    SelectCoursePanel() {
        java = new JCheckBox("Java");
        swing = new JCheckBox("Spring");
        hibernate = new JCheckBox("Hibernate");

        setLayout(new FlowLayout());
        add(java);
        add(swing);
        add(hibernate);

    }
}
