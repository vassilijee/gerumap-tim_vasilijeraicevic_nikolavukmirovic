package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.repository.composite.MapNode;
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
        this.s = new Line2D.Double();
    }

    @Override
    public void update(Object publisher, Object notification) {

    }
}
