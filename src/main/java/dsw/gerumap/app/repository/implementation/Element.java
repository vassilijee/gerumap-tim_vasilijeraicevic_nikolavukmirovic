package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {
    private Color color;
    private int stroke;

    public Element(String name, MapNode parent) {
        super(name, parent);
        this.color = Color.black;
        this.stroke = 2;
    }

    public void setColor(Color color) {
        this.color = color;
        this.notifySubscribers(this, "REPAINT");
    }
}
