package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.SelectionRect;

import java.awt.*;

public class SelectionRectView implements ISubscriber {
    private SelectionRect selectionRect;
    private Shape s;

    public SelectionRectView(SelectionRect selectionRect) {
        this.selectionRect = selectionRect;
        this.s = new Rectangle();
    }

    @Override
    public void update(Object publisher, Object notification) {

    }
}
