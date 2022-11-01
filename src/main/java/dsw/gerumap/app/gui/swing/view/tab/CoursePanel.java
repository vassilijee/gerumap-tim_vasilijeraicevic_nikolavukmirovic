package dsw.gerumap.app.gui.swing.view.tab;

import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {
    JButton addCourse, clear;

    CoursePanel() {
        addCourse = new JButton("Add Course");
        clear = new JButton("Clear");

        setLayout(new FlowLayout());

        add(addCourse);
        add(clear);

    }
}