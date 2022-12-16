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
        g2.setColor(element.getColor());
        g2.setStroke(new BasicStroke(element.getStroke()));
        g2.setBackground(Color.WHITE);
        g2.draw(s);
        if (!(m.getMapSelectionModel().getSelected().isEmpty())) {
            if (m.getMapSelectionModel().getSelected().contains(element)) {
                g2.setStroke(new BasicStroke(4));
                g2.setColor(Color.RED);
                g2.draw(s);
            }
        }
        if (element instanceof Topic) {
            Topic t = (Topic) element;
            g2.drawString(t.getName(), t.getX() + t.getW() / 3, t.getY() + t.getH() / 2);
        } else if (element instanceof Link) {
            Link l = (Link) element;
            if (l.getStartX() != 0 && l.getStartY() != 0) {
                g2.draw(s);
            }
        } else if (element instanceof SelectionRect) {
            g2.draw(s);
        }
    }

    public boolean elementAt(int x, int y) {
        return s.contains(x, y);
    }
}
