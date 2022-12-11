package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ElementView implements ISubscriber {
    protected Shape s;
    private Element element;

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(element.getColor());
        g2.setStroke(new BasicStroke(element.getStroke()));
        g2.draw(s);
    }

    public void elementAt(int x, int y){
        s.contains(x, y);
    }
}
