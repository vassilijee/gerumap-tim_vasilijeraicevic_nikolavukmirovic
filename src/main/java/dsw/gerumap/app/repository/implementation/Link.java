package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link extends Element {
    private Topic topicFrom;
    private Topic topicTo;

    public Link(String name, MapNode parent) {
        super(name, parent);
        this.topicFrom = null;
        this.topicTo = null;
    }
    public void move(){
        this.notifySubscribers(this, "MOVE");
    }

    public void setTopicFrom(Topic topicFrom) {
        this.topicFrom = topicFrom;
        this.notifySubscribers(this, "REPAINT");
    }

    public void setTopicTo(Topic topicTo) {
        this.topicTo = topicTo;
        this.notifySubscribers(this, "REPAINT");
    }
}
