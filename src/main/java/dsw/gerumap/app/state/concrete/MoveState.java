package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
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
                    topic.setX(topic.getX() + x);
                    topic.setY(topic.getY() + y);
                    m.repaint();
                }else if(element instanceof Link){
                    Link link = (Link) element;
                    link.setStartX(link.getStartX() + x);
                    link.setStartY(link.getStartY() + y);
                    link.setEndXY(x, y);
                }
            }
        }else{

        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
    }
}
