package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SelectionRect extends Element {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public SelectionRect(String name, MapNode parent) {
        super(name, parent);
    }

    public void setEndXY(int x, int y) {
        this.setEndX(x);
        this.setEndY(y);
        this.notifySubscribers(this, "REPAINT");
    }

    public void setStartXY(int x, int y) {
        this.setStartX(x);
        this.setStartY(y);
        this.notifySubscribers(this, "REPAINT");
    }
}
