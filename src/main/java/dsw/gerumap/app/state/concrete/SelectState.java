package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.repository.implementation.SelectionRect;
import dsw.gerumap.app.state.State;

import java.awt.geom.Rectangle2D;


public class SelectState extends State {
    SelectionRect selectionRect;
    static int startX, startY;

    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        m.getMapSelectionModel().getSelected().clear();
        selectionRect = new SelectionRect("Sel", m.getMindMap());
        selectionRect.addSubscriber(m);
        for (ElementView ew :
                m.getPainters()) {
            if (ew.elementAt(x, y) && !(m.getMapSelectionModel().getSelected().contains(ew.getElement()))) {
                m.getMapSelectionModel().getSelected().add(ew.getElement());
            }
        }
        selectionRect.setStartXY(x, y);
        selectionRect.setEndXY(x, y);
        m.getMindMap().addChild(selectionRect);
        startX = x;
        startY = y;
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        int minX = Math.min(x, startX);
        int minY = Math.min(y, startY);
        int maxX = Math.max(x, startX);
        int maxY = Math.max(y, startY);
        selectionRect.setStartX(minX);
        selectionRect.setStartY(minY);
        selectionRect.setW(maxX - minX);
        selectionRect.setH(maxY - minY);
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        int minX = Math.min(x, startX);
        int minY = Math.min(y, startY);
        int maxX = Math.max(x, startX);
        int maxY = Math.max(y, startY);
        selectionRect.setStartX(minX);
        selectionRect.setStartY(minY);
        selectionRect.setW(maxX - minX);
        selectionRect.setH(maxY - minY);
        ElementView ew1 = m.getPainterByElement(selectionRect);
        m.getPainters().remove(ew1);
        for (ElementView ew : m.getPainters()) {
            if (ew.getS().intersects((Rectangle2D) ew1.getS()) && !(m.getMapSelectionModel().getSelected().contains(ew.getElement()))) {
                m.getMapSelectionModel().getSelected().add(ew.getElement());
            }
        }
        m.getMindMap().removeChild(selectionRect);
        selectionRect = null;
    }
}
