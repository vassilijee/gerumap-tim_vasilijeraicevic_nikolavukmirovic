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
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {

    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            for (Element element:
                 m.getMapSelectionModel().getSelected()) {
                if(element instanceof Topic){
                    Topic topic = (Topic) element;
                    topic.setXY(topic.getX() + x, topic.getY() + y);
                }else if(element instanceof Link){
                    Link link = (Link) element;
                    link.setStartX(link.getStartX() + x);
                    link.setStartY(link.getStartY() + y);
                    link.setEndXY(link.getEndX() + x, link.getEndY() + y);
                }
            }
        }else{
            for (ElementView elementView:
                    m.getPainters()) {
                if(elementView instanceof TopicView){
                    Topic topic = (Topic) elementView.getElement();
                    topic.setXY(topic.getX() + x, topic.getY() + y);
                }else if(elementView instanceof LinkView){
                    Link link =(Link) elementView.getElement();
                    link.setStartX(link.getStartX() + x);
                    link.setStartY(link.getStartY() + y);
                    link.setEndXY(link.getEndX() + x, link.getEndY() + y);
                }
            }
        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
    }
}
