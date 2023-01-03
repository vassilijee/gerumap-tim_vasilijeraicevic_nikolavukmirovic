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
        this.s = new Line2D.Double(link.getTopicFrom().getX() + link.getTopicFrom().getW() / 2,
                link.getTopicFrom().getY() + link.getTopicFrom().getH() / 2,
                link.getTopicTo().getX() + link.getTopicTo().getW() / 2,
                link.getTopicTo().getY() + link.getTopicTo().getH() / 2);
    }

    @Override
    public void update(Object publisher, Object notification) {
        if (notification.equals("REPAINT")) {
            this.s = new Line2D.Double(link.getTopicFrom().getX() + link.getTopicFrom().getW() / 2,
                    link.getTopicFrom().getY() + link.getTopicFrom().getH() / 2,
                    link.getTopicTo().getX() + link.getTopicTo().getW() / 2,
                    link.getTopicTo().getY() + link.getTopicTo().getH() / 2);
        } else if (notification.equals("MOVE")) {
            this.s = new Line2D.Double(link.getTopicFrom().getX() + link.getTopicFrom().getW() / 2,
                    link.getTopicFrom().getY() + link.getTopicFrom().getH() / 2,
                    link.getTopicTo().getX() + link.getTopicTo().getW() / 2,
                    link.getTopicTo().getY() + link.getTopicTo().getH() / 2);
        }
    }
}
