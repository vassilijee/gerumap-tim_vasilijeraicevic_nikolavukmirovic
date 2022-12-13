package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
        if (link == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.NOTHING_IS_SELECTED);
        }else{
            m.getMindMap().addChild(link);
        }
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        super.draggedMouse(x, y, m);
        int i = count - 1;
        Link link = (Link) m.getMindMap().getChildByName("Link" + i);
        link.setEndXY(x, y);
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
        boolean flag = true;
        boolean same = false;
        int i = count - 1;
        for (ElementView elementView : m.getPainters()) {
            if (elementView.elementAt(x, y) && elementView instanceof TopicView) {
                link = (Link) m.getMindMap().getChildByName("Link" + i);
                link.setEndXY(x, y);
                flag = false;
                link.setTopicDo(((TopicView) elementView).getTopic());
                if(link.getTopidOd() == link.getTopicDo()){
                    same = true;
                }
            }
        }
        if(same){
            m.getMindMap().removeChild(link);
        }
        if (flag) {
            // za sad je ovo budzevina, dok ne bude deleteLink
            link.setStartXY(0,0);
            link = null;
            //ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.NOTHING_IS_SELECTED);
        }
    }


}
