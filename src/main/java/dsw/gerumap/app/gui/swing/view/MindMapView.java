package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {
    private String title;
    private MindMap mindMap;

    public MindMapView() {
        this.mindMap = null;
        title = "";
    }

    @Override
    public void update(Object iPublisher, Object notification) {
//        if (notification.equals("RENAME")) {
//            TabbedPane pane = MainFrame.getInstance().getProjectView().getTabbedPane();
//            int index = pane.indexOfTab(this.getTitle());
//            pane.setTitleAt(index, this.getTitle());
//        } else if (notification.equals("DELETE")) {
//            TabbedPane pane = MainFrame.getInstance().getProjectView().getTabbedPane();
//            int index = pane.indexOfTab(this.getTitle());
//            pane.removeTabAt(index);
//        }
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
        title = mindMap.getName();
    }
}
