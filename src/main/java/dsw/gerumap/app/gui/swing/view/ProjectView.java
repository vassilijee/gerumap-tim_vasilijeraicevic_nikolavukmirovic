package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Setter
@Getter

public class ProjectView extends JPanel implements ISubscriber {
    private TabbedPane tabbedPane;
    private JLabel projectName;
    private JPanel desktop;
    private Project project;

    public ProjectView() {
        this.project = null;
        this.setLayout(new BorderLayout());
        projectName = new JLabel("", JLabel.CENTER);
        tabbedPane = new TabbedPane();
        this.add(tabbedPane, BorderLayout.CENTER);
        this.add(projectName, BorderLayout.NORTH);
    }

    @Override
    public void update(Object object, Object notification) {
        if(notification.equals("NEW")){
            MindMapView tab = new MindMapView();
            tab.setMindMap((MindMap) object);
            ((MindMap) object).addSubscriber(this);
            tabbedPane.addTab(((MindMap) object).getName(), tab);
        }else if(notification.equals("RENAME")){
            if(object instanceof Project){
                this.projectName.setText(this.project.getName() + " Autor: " + this.project.getAuthor());
            }else if(object instanceof  MindMap){
                tabbedPane.setTitleAt(project.getChildren().indexOf((MindMap) object), ((MindMap) object).getName());
            }
        }else if(notification.equals("DELETE")){
            tabbedPane.remove(project.getChildren().indexOf((MindMap)object));
        }else if(notification.equals("AUTHOR")){
            this.projectName.setText(this.project.getName() + " Autor: " + this.project.getAuthor());
        }
    }

    public void setProject(Project project) {
        if(this.project != null){
            this.project.removeSubscriber(this);
        }
        if(project == null){
            projectName.setText("");
            tabbedPane.removeAll();
            return;
        }
        this.project = project;
        project.addSubscriber(this);
        projectName.setText(this.project.getName() + " Autor: " + this.project.getAuthor());
        tabbedPane.removeAll();
        for (MapNode child:
             project.getChildren()) {
            MindMapView tab = new MindMapView();
            tab.setMindMap((MindMap) child);
            child.addSubscriber(this);
            tabbedPane.add(tab.getTitle(), tab);
            tab.add(new JLabel(tab.getTitle()));
        }
        //MainFrame.getInstance().getMapTree().expandPath();
    }
}
