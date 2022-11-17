package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

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
    public void update(Object object, Object notification) {
        if (notification.equals("RENAME")) {
            this.removeAll();
            this.add(new JLabel(mindMap.getName()));
        }
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);
        title = mindMap.getName();
    }
}
