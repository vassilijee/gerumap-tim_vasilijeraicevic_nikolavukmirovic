package dsw.gerumap.app.state;

import dsw.gerumap.app.gui.swing.view.MindMapView;


public abstract class State {
    public void clickedMouse(int x, int y, MindMapView m) {
    }
    public void releasedMouse(int x, int y, MindMapView m){
    }
    public void draggedMouse(int x, int y, MindMapView m){
    }
}
