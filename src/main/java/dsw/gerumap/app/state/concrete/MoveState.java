package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.command.implementation.MoveCommand;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;

import java.util.HashMap;

public class MoveState extends State {
    private static int clickedX;
    private static int clickedY;
    private static HashMap<String, Integer> cordX = new HashMap<>();
    private static HashMap<String, Integer> cordY = new HashMap<>();
    private static int x1;
    private static int y1;
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        clickedX = x;
        clickedY = y;
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            for (Element element:
                 m.getMapSelectionModel().getSelected()) {
                if(element instanceof Topic){
                    Topic topic = (Topic) element;
                    cordX.put(topic.getName(), topic.getX());
                    cordY.put(topic.getName(), topic.getY());
                }
            }
        }
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            for (Element element :
                    m.getMapSelectionModel().getSelected()) {
                if (element instanceof Topic) {
                    Topic topic = (Topic) element;
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    x1 = locationX + (x - clickedX);
                    y1 = locationY + (y - clickedY);
                    topic.setXY(x1, y1);
                } else if (element instanceof Link) {
                    Link link = (Link) element;
                    link.move();
                }
            }
            for (ElementView elementView :
                    m.getPainters()) {
                if (elementView instanceof LinkView) {
                    Link link = (Link) elementView.getElement();
                    link.move();
                }
            }
            clickedX += (x - clickedX);
            clickedY += (y - clickedY);
        } else {
            for (ElementView elementView :
                    m.getPainters()) {
                if (elementView instanceof TopicView) {
                    Topic topic = (Topic) elementView.getElement();
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    x1 = locationX + (x - clickedX);
                    y1 = locationY + (y - clickedY);
                    topic.setXY(x1, y1);
                } else if (elementView instanceof LinkView) {
                    Link link = (Link) elementView.getElement();
                    link.move();
                }
            }
            clickedX += (x - clickedX);
            clickedY += (y - clickedY);
        }
    }
    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            AbstractCommand abstractCommand = new MoveCommand(m.getMapSelectionModel(), cordX, cordY, x1, y1);
            m.getMindMap().getCommandManager().addCommand(abstractCommand);
        }
    }
}