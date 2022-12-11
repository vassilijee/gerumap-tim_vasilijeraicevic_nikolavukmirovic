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
        this.color = Color.green;
        this.stroke = 2;
    }
}
