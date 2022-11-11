package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Project;
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
    private MindMapView desktop;

    public ProjectView(JTree projectExplorer) {
        desktop = new MindMapView(new BorderLayout());
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
    public void update(IPublisher iPublisher, Object notification) {
        if(notification.equals("RENAME")){
            Project project = (Project) iPublisher;
            MainFrame.getInstance().getProjectView().getProjectName().setText(project.getName()+  " Autor: "+ project.getAuthor());
        }else if(notification.equals("DELETE")){
            MainFrame.getInstance().getProjectView();
        }else if(notification.equals("AUTHOR")){
            Project project = (Project) iPublisher;
            MainFrame.getInstance().getProjectView().getProjectName().setText(project.getName() + " Autor: "+ project.getAuthor());
        }

    }
}
