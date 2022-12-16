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
    private static Color color1 = null;
    private static int stroke1 = -1;



    public Element(String name, MapNode parent) {
        super(name, parent);
        if(color1 != null)
            this.color = color1;
        else
            this.color = Color.black;
        if(stroke1 > 0)
            this.stroke = stroke1;
        else
            this.stroke = 2;
    }

    public void setColor(Color color) {
        this.color = color;
        this.notifySubscribers(this, "REPAINT");
    }

    public static void setColor1(Color color1) {
        Element.color1 = color1;
    }

    public static void setStroke1(int stroke1) {
        Element.stroke1 = stroke1;
    }
}
