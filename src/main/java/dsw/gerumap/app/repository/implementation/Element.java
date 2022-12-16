package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {
    private Color color;
    private static Color color1 = null;

    private int stroke;

    public Element(String name, MapNode parent) {
        super(name, parent);
        this.stroke = 2;
        if(color1 != null)
            this.color = color1;
        else
            this.color = Color.black;
    }

    public void setColor(Color color) {
        this.color = color;
        this.notifySubscribers(this, "REPAINT");
    }

    public static void setColor1(Color color1) {
        Element.color1 = color1;
    }
}
