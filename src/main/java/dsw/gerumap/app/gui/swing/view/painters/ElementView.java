package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Element;
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

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(element.getColor());
        g2.setStroke(new BasicStroke(element.getStroke()));
        g2.draw(s);
        if(element instanceof Topic){
            Topic t = (Topic) element;
            g2.drawString(t.getName(), t.getX()+t.getW()/3, t.getY()+t.getH()/2);
        }
    }

    public void elementAt(int x, int y){
        s.contains(x, y);
    }
}
