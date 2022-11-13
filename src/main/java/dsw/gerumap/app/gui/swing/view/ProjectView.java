package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter

public class ProjectView extends JPanel implements ISubscriber {
    private TabbedPane tabbedPane;
    private JLabel projectName;
    private JPanel desktop;

    public ProjectView() {
        this.setLayout(new BorderLayout());
        projectName = new JLabel("", JLabel.CENTER);
        tabbedPane = new TabbedPane();
        this.add(tabbedPane, BorderLayout.CENTER);
        this.add(projectName, BorderLayout.NORTH);
    }

    @Override
    public void update(IPublisher iPublisher, Object notification) {
        if (notification.equals("RENAME")) {
            Project project = (Project) iPublisher;
            MainFrame.getInstance().getProjectView().getProjectName().setText(project.getName() + " Autor: " + project.getAuthor());
        } else if (notification.equals("DELETE")) {
            MainFrame.getInstance().getProjectView().getTabbedPane().removeAll();
            MainFrame.getInstance().getProjectView().getProjectName().setText("");
        } else if (notification.equals("AUTHOR")) {
            Project project = (Project) iPublisher;
            MainFrame.getInstance().getProjectView().getProjectName().setText(project.getName() + " Autor: " + project.getAuthor());
        } else if (notification.equals("NEW")) {
            int index = MainFrame.getInstance().getMapTree().getSelectedNode().getChildCount();
            String name = String.valueOf(MainFrame.getInstance().getMapTree().getSelectedNode().getChildAt(index - 1));
            TabbedPane pane = MainFrame.getInstance().getProjectView().getTabbedPane();
            MindMapView tab = new MindMapView();
            MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().addSubscriber(MainFrame.getInstance().getProjectView());
            tab.setTitle(name);
            pane.addTab(tab.getTitle(), tab);
            tab.add(new JLabel(tab.getTitle()));
            // ovaj -1 ga muci nesto, radi ali izbacuje greske kad se renameuje novi MindMap nakon sto ga je dodao observer
            MapTreeItem item = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode().getChildren().get(MainFrame.getInstance().getMapTree().getSelectedNode().getChildCount() - 1);
            item.getMapNode().addSubscriber(tab);
        }
    }
}
