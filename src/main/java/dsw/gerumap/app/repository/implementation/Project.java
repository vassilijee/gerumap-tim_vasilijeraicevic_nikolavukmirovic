package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Project extends MapNodeComposite {
    private String author = "/";

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof MindMap) {
            MindMap map = (MindMap) child;
            if (this.getChildren().contains(map)) {
                this.getChildren().add(map);
            }
        }
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if (this.getSubscriberList() == null)
            this.setSubscriberList(new ArrayList<>());
        if (this.getSubscriberList().contains(sub))
            return;
        this.getSubscriberList().add(sub);
        System.out.println("dodat");
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.getSubscriberList() == null || !this.getSubscriberList().contains(sub)) return;
        this.getSubscriberList().remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.getSubscriberList() == null || this.getSubscriberList().isEmpty()) return;

        for (ISubscriber listener : getSubscriberList()) {
            listener.update(this, notification);
        }
    }
}
