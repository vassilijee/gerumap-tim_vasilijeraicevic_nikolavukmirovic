package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.repository.implementation.Link;
import lombok.Getter;
import lombok.Setter;

import java.awt.geom.Line2D;

@Getter
@Setter
public class LinkView extends ElementView {
    private Link link;

    public LinkView(Link link) {
        super(link);
        this.link = link;
        this.s = new Line2D.Double(link.getStartX(), link.getStartY(), link.getEndX(), link.getEndY());
    }

    @Override
    public void update(Object publisher, Object notification) {
        if (notification.equals("REPAINT")) {
            this.s = new Line2D.Double(link.getStartX(), link.getStartY(), link.getEndX(), link.getEndY());
        }else if(notification.equals("MOVE")){
            this.s = new Line2D.Double(link.getTopicFrom().getX(), link.getTopicFrom().getY(), link.getTopicTo().getX(), link.getTopicTo().getY());
        }
    }
}
