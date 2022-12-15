package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public class SelectionRect extends Element{
    private int startX, startY, endX, endY, w, h;
    private Stroke stroke1;
    private float[] dashingPattern1 = {2f, 2f};

    public SelectionRect(String name, MapNode parent) {
        super(name, parent);
        this.stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
    }

    public void setEndXY(int x, int y) {
        this.setEndX(x);
        this.setEndY(y);
        this.setW(endX - startX);
        this.setH(endY - startY);
        this.notifySubscribers(this, "REPAINT");
    }

    public void setStartXY(int x, int y) {
        this.setStartX(x);
        this.setStartY(y);
        this.notifySubscribers(this, "REPAINT");
    }
}
