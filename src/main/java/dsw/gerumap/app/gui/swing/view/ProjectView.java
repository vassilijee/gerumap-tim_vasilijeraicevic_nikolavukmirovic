package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.controller.TabAction;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Setter
@Getter

public class ProjectView extends JFrame implements ISubscriber {
    private TabbedPane tabbedPane;
    private JLabel projectName;
    private JScrollPane scroll;
    private JSplitPane split;
    private JPanel desktop;

    public ProjectView(JTree projectExplorer) {
        desktop = new JPanel(new BorderLayout());
        scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
        projectName = new JLabel("", JLabel.CENTER);
        tabbedPane = new TabbedPane();
        desktop.add(tabbedPane, BorderLayout.CENTER);
        desktop.add(projectName, BorderLayout.NORTH);
    }

    @Override
    public void update(Object notification) {
        MainFrame.getInstance().getProjectView().getProjectName().setText(notification.toString());
    }
}
