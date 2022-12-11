package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {
    private String title;
    private MindMap mindMap;
    private List<ElementView> painters;

    public MindMapView() {
        this.mindMap = null;
        title = "";
        this.painters = new ArrayList<>();
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

    private class MouseController extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(e.getButton() == MouseEvent.BUTTON1){

            }
        }
    }
}
