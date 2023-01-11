package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.SelectionRect;
import dsw.gerumap.app.repository.implementation.Topic;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ElementView implements ISubscriber {
    protected Shape s;
    private Element element;

    public ElementView(Element element) {
        this.element = element;
    }

    public void draw(Graphics g, MindMapView m) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(element.getColorI()));
        g2.setStroke(new BasicStroke(element.getStroke()));
        g2.setBackground(Color.WHITE);
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            if (m.getMapSelectionModel().getSelected().contains(element)) {
                float[] dashingPattern1 = {2f, 2f};
                g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f));
                g2.setColor(Color.red);
                g2.draw(s);
            }
        }
        if (element instanceof Topic) {
            Topic t = (Topic) element;
            g2.draw(s);
            g2.drawString(t.getName(), t.getX() + t.getW() / 3, t.getY() + t.getH() / 2);
        } else if (element instanceof Link) {
            g2.draw(s);
        } else if (element instanceof SelectionRect) {
            g2.setStroke(((SelectionRect) element).getStroke1());
            g2.setColor(Color.black);
            g2.draw(s);
        }
    }

    public boolean elementAt(int x, int y) {
        return s.contains(x, y);
    }
}
