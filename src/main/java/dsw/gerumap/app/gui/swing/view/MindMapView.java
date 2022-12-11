package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
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
    private MindMapView mindMapView = this;
    private MouseController mouseController;

    public MindMapView() {
        this.mindMap = null;
        title = "";
        this.painters = new ArrayList<>();
        mouseController = new MouseController();
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    @Override
    public void update(Object object, Object notification) {
        if (notification.equals("RENAME")) {
            //this.removeAll();
            //this.add(new JLabel(mindMap.getName()));
        }else if(notification.equals("NEW")){
            if(object instanceof Topic){
                TopicView topicView = new TopicView((Topic) object);
                painters.add(topicView);
                ((Topic) object).addSubscriber(topicView);
                ((Topic) object).addSubscriber(this);
                repaint();
            }else if(object instanceof Link){
                LinkView linkView = new LinkView((Link) object);
                painters.add(linkView);
                ((Link) object).addSubscriber(linkView);
                ((Link) object).addSubscriber(this);
                repaint();
            }
        }
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);
        title = mindMap.getName();
        for (MapNode child:
             mindMap.getChildren()) {
            if(child instanceof Topic){
                TopicView topicView = new TopicView((Topic) child);
                painters.add(topicView);
                child.addSubscriber(this);
                child.addSubscriber(topicView);
                repaint();
            }else if(child instanceof Link){
                LinkView linkView = new LinkView((Link) child);
                painters.add(linkView);
                child.addSubscriber(this);
                child.addSubscriber(linkView);
                repaint();
            }
        }
    }

    private class MouseController extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            MainFrame.getInstance().getProjectView().clickedMouse(e.getX(), e.getY(), mindMapView);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ElementView p:
             painters) {
            System.out.println(painters.size());
            p.draw(g);
            System.out.println("CRTAM");
        }
    }
}
