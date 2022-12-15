package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.state.State;

import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        ElementView e = null;
        List<Element> selected = new ArrayList<>();
        List<ElementView> selectedEw = new ArrayList<>();
        if(!(m.getMapSelectionModel().getSelected().isEmpty())){
            for (ElementView ew:
                 m.getPainters()) {
                if(m.getMapSelectionModel().getSelected().contains(ew.getElement())){
                    selectedEw.add(ew);
                    selected.add(ew.getElement());
                }
            }
            if(!(selected.isEmpty())){
                m.getPainters().removeAll(selectedEw);
                m.getMindMap().getChildren().removeAll(selected);
                m.getMapSelectionModel().clearSelected(selected);
            }
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
