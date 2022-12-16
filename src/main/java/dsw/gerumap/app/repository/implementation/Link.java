package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link extends Element {
    private Topic topidOd;
    private Topic topicDo;
    private int startX, startY, endX, endY;

    public Link(String name, MapNode parent) {
        super(name, parent);
    }

    public void setEndXY(int x, int y) {
        this.setEndX(x);
        this.setEndY(y);
        this.notifySubscribers(this, "REPAINT");
    }
    public void move(){
        this.notifySubscribers(this, "MOVE");
    }
}
