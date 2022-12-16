package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
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
        List<ElementView> selectedEw2 = new ArrayList<>();
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            for (ElementView ew :
                    m.getPainters()) {
                if (m.getMapSelectionModel().getSelected().contains(ew.getElement())) {
                    selectedEw.add(ew);
                    selected.add(ew.getElement());
                }
            }
            for (ElementView selektovan :
                    selectedEw) {
                deleteSelected(m, selected, selectedEw2, selektovan);
            }
            m.getPainters().removeAll(selectedEw);
            m.getPainters().removeAll(selectedEw2);
            m.getMindMap().getChildren().removeAll(selected);
            m.getMapSelectionModel().clearSelected();
            selected.clear();
            selectedEw2.clear();
            selectedEw.clear();
        } else {
            for (ElementView elementView :
                    m.getPainters()) {
                if (elementView.elementAt(x, y)) {
                    e = elementView;
                }
            }
            if (e != null) {
                deleteSelected(m, selected, selectedEw, e);
                m.getMindMap().removeChild(e.getElement());
                m.getPainters().removeAll(selectedEw);
                m.getMindMap().getChildren().removeAll(selected);
            }
        }
    }

    private void deleteSelected(MindMapView m, List<Element> selected, List<ElementView> selectedEw2, ElementView selektovan) {
        if (selektovan instanceof TopicView) {
            for (ElementView painter :
                    m.getPainters()) {
                if (painter instanceof LinkView) {
                    if (((LinkView) painter).getLink().getTopicTo().equals(((TopicView) selektovan).getTopic()) ||
                            ((LinkView) painter).getLink().getTopicFrom().equals(((TopicView) selektovan).getTopic())) {
                        selectedEw2.add(painter);
                        selected.add(painter.getElement());
                    }
                }
            }
        }
    }
}
