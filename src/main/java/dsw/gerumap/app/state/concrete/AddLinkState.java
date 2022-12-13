package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.state.State;

import java.awt.*;

public class AddLinkState extends State {
    static int count;
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        super.clickedMouse(x, y, m);
        Link link = new Link("Link" + count, m.getMindMap());
        link.setStartX(x);
        link.setStartY(y);
        link.setEndXY(x, y);
        count++;
        m.getMindMap().addChild(link);
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
        int i = count - 1;
        Link link = (Link) m.getMindMap().getChildByName("Link" + i);
        link.setEndXY(x, y);
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        super.draggedMouse(x, y, m);
        int i = count - 1;
        Link link = (Link) m.getMindMap().getChildByName("Link" + i);
        link.setEndXY(x, y);
    }
}
