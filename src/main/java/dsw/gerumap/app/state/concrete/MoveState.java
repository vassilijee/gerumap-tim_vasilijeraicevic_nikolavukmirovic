package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.state.State;

public class MoveState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        super.clickedMouse(x, y, m);
//        for (ElementView elementView : m.getPainters()) {
////            if (elementView.elementAt(x, y)) {
////                // move element
////            }
//        }

    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {

    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
    }
}
