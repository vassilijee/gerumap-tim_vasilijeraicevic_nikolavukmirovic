package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.command.implementation.DeleteCommand;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.state.State;

import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        ElementView elementView = null;
        List<Element> selected = new ArrayList<>();
        List<ElementView> selectedElementView = new ArrayList<>();
        List<ElementView> selectedElementView1 = new ArrayList<>();
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            for (ElementView elementView1 :
                    m.getPainters()) {
                if (m.getMapSelectionModel().getSelected().contains(elementView1.getElement())) {
                    selectedElementView.add(elementView1);
                    selected.add(elementView1.getElement());
                }
            }
            for (ElementView selektovan :
                    selectedElementView) {
                findLinks(m, selected, selectedElementView1, selektovan);
            }
            m.getPainters().removeAll(selectedElementView);
            m.getPainters().removeAll(selectedElementView1);
            AbstractCommand abstractCommand = new DeleteCommand(m.getMindMap(), selected, m.getMapSelectionModel());
            m.getMindMap().getCommandManager().addCommand(abstractCommand);
            selected.clear();
            selectedElementView.clear();
            selectedElementView1.clear();
        } else {
            for (ElementView elementView1 :
                    m.getPainters()) {
                if (elementView1.elementAt(x, y)) {
                    elementView = elementView1;
                }
            }
            if (elementView != null) {
                selected.add(elementView.getElement());
                selectedElementView.add(elementView);
                findLinks(m, selected, selectedElementView, elementView);
                m.getPainters().removeAll(selectedElementView);
                AbstractCommand abstractCommand = new DeleteCommand(m.getMindMap(), selected, m.getMapSelectionModel());
                m.getMindMap().getCommandManager().addCommand(abstractCommand);
                selected.clear();
                selectedElementView.clear();
            }
        }
    }

    private void findLinks(MindMapView m, List<Element> selected, List<ElementView> selectedElementView1, ElementView selektovan) {
        if (selektovan instanceof TopicView) {
            for (ElementView elementView :
                    m.getPainters()) {
                if (elementView instanceof LinkView) {
                    if (((LinkView) elementView).getLink().getTopicTo().equals(((TopicView) selektovan).getTopic()) ||
                            ((LinkView) elementView).getLink().getTopicFrom().equals(((TopicView) selektovan).getTopic())) {
                        selectedElementView1.add(elementView);
                        selected.add(elementView.getElement());
                    }
                }
            }
        }
    }
}
