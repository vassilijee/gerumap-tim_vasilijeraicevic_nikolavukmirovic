package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.SelectionRect;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class SelectionRectView extends ElementView{
    private SelectionRect selectionRect;

    public SelectionRectView(SelectionRect selectionRect) {
        super(selectionRect);
        this.selectionRect = selectionRect;
        this.s = new Rectangle2D.Double(selectionRect.getStartX(), selectionRect.getStartY(), selectionRect.getW(), selectionRect.getH());
    }

    @Override
    public void update(Object publisher, Object notification) {
        if(notification.equals("REPAINT")){
            this.s = new Rectangle2D.Double(selectionRect.getStartX(), selectionRect.getStartY(), selectionRect.getW(), selectionRect.getH());
        }
    }
}
