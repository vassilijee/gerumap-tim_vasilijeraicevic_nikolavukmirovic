package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {
    private int colorI;
    private int stroke;
    private static int color1I = -16777216;
    private static int stroke1 = -1;



    public Element(String name, MapNode parent) {
        super(name, parent);
        if(color1I != -16777216){
            this.colorI = color1I;
        }
        else{
            this.colorI = Color.black.getRGB();
        }

        if(stroke1 > 0)
            this.stroke = stroke1;
        else
            this.stroke = 2;
    }

    public void setColor(Color color) {
        this.colorI = color.getRGB();
        this.notifySubscribers(this, "REPAINT");
    }

    public static void setColor1I(Color color1) {
        Element.color1I = color1.getRGB();
    }

    public static void setStroke1(int stroke1) {
        Element.stroke1 = stroke1;
    }
}
