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
    }

    @Override
    public void update(IPublisher iPublisher, Object notification) {
        if (notification.equals("RENAME")) {
            MindMap map = (MindMap) iPublisher;
            TabbedPane pane = MainFrame.getInstance().getProjectView().getTabbedPane();
            int index = pane.indexOfTab(this.getTitle());
            this.setTitle(map.getName());
            pane.setTitleAt(index, this.getTitle());
        } else if (notification.equals("DELETE")) {
            MindMap map = (MindMap) iPublisher;
            TabbedPane pane = MainFrame.getInstance().getProjectView().getTabbedPane();
            int index = pane.indexOfTab(this.getTitle());
            pane.removeTabAt(index);
        }
    }

    public void setMindMap(MindMap mindMap) {
        if(this.mindMap != null){
            this.mindMap.removeSubscriber(this);
        }else{
            title = "";
        }
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);
    }
}
