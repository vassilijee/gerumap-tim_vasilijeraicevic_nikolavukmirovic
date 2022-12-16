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
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            for (Element element :
                    m.getMapSelectionModel().getSelected()) {
                if (element instanceof Topic) {
                    Topic topic = (Topic) element;
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    int x1 = locationX - clickedX + x;
                    int y1 = locationY - clickedY + y;
                    topic.setXY(x1, y1);
                    clickedX = x1;
                    clickedY = y1;
                } else if (element instanceof Link) {
                    Link link = (Link) element;
                    int locationX = link.getStartX();
                    int locationY = link.getStartY();
                    int x1 = locationX - clickedX + x;
                    int y1 = locationY - clickedY + y;
                    link.setStartX(x1);
                    link.setStartY(y1);
                    //link.setEndXY(newX, newY);
                    clickedX = x1;
                    clickedY = y1;
                }
            }
        } else {
            for (ElementView elementView :
                    m.getPainters()) {
                if (elementView instanceof TopicView) {
                    Topic topic = (Topic) elementView.getElement();
                    int locationX = topic.getX();
                    int locationY = topic.getY();
                    int x1 = locationX - clickedX + x;
                    int y1 = locationY - clickedY + y;
                    topic.setXY(x1, y1);
                    clickedX = x1;
                    clickedY = y1;
                } else if (elementView instanceof LinkView) {
                    Link link = (Link) elementView.getElement();
                    int locationX = link.getStartX();
                    int locationY = link.getStartY();
                    int x1 = locationX - clickedX + x;
                    int y1 = locationY - clickedY + y;
                    link.setStartX(x1);
                    link.setStartY(y1);
                    //link.setEndXY(newX, newY);
                    clickedX = x1;
                    clickedY = y1;
                }
            }
        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        clickedY = 0;
        clickedX = 0;
    }
}
