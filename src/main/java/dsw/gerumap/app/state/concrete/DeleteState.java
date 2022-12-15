package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.state.State;

import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        ElementView e = null;
        List<ElementView> selected = new ArrayList<>();
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            for (ElementView ew:
                 m.getPainters()) {
                if(m.getMapSelectionModel().getSelected().contains(ew.getElement())){
                    selected.add(ew);
                }
            }
            System.out.println(selected.size());
            m.getPainters().removeAll(selected);
            m.getMindMap().getChildren().removeAll(selected);
            m.repaint();
            m.getMapSelectionModel().getSelected().clear();
        }else{
            for (ElementView elementView:
                 m.getPainters()) {
                if(elementView.elementAt(x, y)){
                    e = elementView;
                }
            }
            if(e != null) {
                m.getMindMap().removeChild(e.getElement());
            }
        }
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
    }
}
