package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;


public class AddLinkState extends State {
    static int count;
    Link link = null;

    Topic topic = new Topic("a", null, 0, 0);

    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        for (ElementView elementView : m.getPainters()) {
            if (elementView.elementAt(x, y) && elementView instanceof TopicView) {
                link = new Link("Link" + count, m.getMindMap());
                count++;
                link.setTopicFrom(((TopicView) elementView).getTopic());
                topic.setX(x);
                topic.setY(y);
                link.setTopicTo(topic);
            }
        }
        if (!(link == null)) {
            m.getMindMap().addChild(link);
        }
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        topic.setX(x);
        topic.setY(y);
        if (!(link == null)) {
            link.setTopicTo(topic);
        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        boolean flag = true;
        if (link == null) {
            return;
        }
        for (ElementView elementView : m.getPainters()) {
            if (elementView.elementAt(x, y) &&
                    elementView instanceof TopicView &&
                    !(link.getTopicFrom().equals(((TopicView) elementView).getTopic()))) {
                flag = false;
                link.setTopicTo(((TopicView) elementView).getTopic());
            }
        }
        if (link.getTopicTo() != null && link.getTopicFrom() != null) {
            for (ElementView ew :
                    m.getPainters()) {
                if (ew instanceof LinkView) {
                    if (((LinkView) ew).getLink().getTopicFrom().equals(link.getTopicFrom()) &&
                            ((LinkView) ew).getLink().getTopicTo().equals(link.getTopicTo()) &&
                            !(((LinkView) ew).getLink().equals(link))) {
                        flag = true;
                    }
                    Topic temp = ((LinkView) ew).getLink().getTopicTo();
                    ((LinkView) ew).getLink().setTopicTo(((LinkView) ew).getLink().getTopicFrom());
                    ((LinkView) ew).getLink().setTopicFrom(temp);
                    if (((LinkView) ew).getLink().getTopicFrom().equals(link.getTopicFrom()) &&
                            ((LinkView) ew).getLink().getTopicTo().equals(link.getTopicTo()) &&
                            !(((LinkView) ew).getLink().equals(link))) {
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            m.getMindMap().removeChild(link);
        }
        link = null;
        topic.setX(0);
        topic.setY(0);
    }
}
