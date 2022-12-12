package dsw.gerumap.app.gui.swing.view.painters;


import dsw.gerumap.app.repository.implementation.Topic;
import lombok.Getter;
import lombok.Setter;

import java.awt.geom.Ellipse2D;

@Getter
@Setter
public class TopicView extends ElementView {
    private Topic topic;

    public TopicView(Topic topic) {
        super(topic);
        this.topic = topic;
        this.s = new Ellipse2D.Double(topic.getX(), topic.getY(), topic.getW(), topic.getH());
    }

    @Override
    public void update(Object publisher, Object notification) {
        if (notification.equals("RENAME")) {
            this.s = new Ellipse2D.Double(topic.getX(), topic.getY(), topic.getW(), topic.getH());
        }
    }
}
