package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.state.State;


public class AddLinkState extends State {
    static int count;
    Link link = null;

    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        super.clickedMouse(x, y, m);
        for (ElementView elementView : m.getPainters()) {
            if (elementView.elementAt(x, y) && elementView instanceof TopicView) {
                link = new Link("Link" + count, m.getMindMap());
                link.setStartX(x);
                link.setStartY(y);
                link.setEndXY(x, y);
                count++;
                link.setTopidOd(((TopicView) elementView).getTopic());
            }
        }
        if (!(link == null)) {
            m.getMindMap().addChild(link);
        }
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        super.draggedMouse(x, y, m);
        if (!(link == null)) {
            link.setEndXY(x, y);
        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
        boolean flag = true;
        if (link == null) {
            return;
        }
        for (ElementView elementView : m.getPainters()) {
            if (elementView.elementAt(x, y) &&
                    elementView instanceof TopicView &&
                    !(link.getTopidOd().equals(((TopicView) elementView).getTopic()))) {
                link.setEndXY(x, y);
                flag = false;
                link.setTopicDo(((TopicView) elementView).getTopic());
            }
        }
        if (link.getTopicDo() != null && link.getTopidOd() != null) {
            for (ElementView ew :
                    m.getPainters()) {
                if (ew instanceof LinkView) {
                    if (((LinkView) ew).getLink().getTopidOd().equals(link.getTopidOd()) &&
                            ((LinkView) ew).getLink().getTopicDo().equals(link.getTopicDo()) &&
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
    }
}
