package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;

public class MoveState extends State {
    private static int clickedX;
    private static int clickedY;
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        clickedX = x;
        clickedY = y;
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            for (Element element:
                 m.getMapSelectionModel().getSelected()) {
                if(element instanceof Topic){
                    Topic topic = (Topic) element;
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    int x1 = locationX + (x - clickedX);
                    int y1 = locationY + (y - clickedY);
                    topic.setXY(x1, y1);
                }else if(element instanceof Link){
                    Link link = (Link) element;
                    link.move();
                }
            }
            for (ElementView elementView:
                 m.getPainters()) {
                if(elementView instanceof LinkView){
                    Link link = (Link) elementView.getElement();
                    link.move();
                }
            }
            clickedX += (x - clickedX);
            clickedY += (y - clickedY);
        }else{
            for (ElementView elementView:
                    m.getPainters()) {
                if(elementView instanceof TopicView){
                    Topic topic = (Topic) elementView.getElement();
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    int x1 = locationX + (x - clickedX);
                    int y1 = locationY + (y - clickedY);
                    topic.setXY(x1, y1);
                }else if(elementView instanceof LinkView){
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
    }
}
