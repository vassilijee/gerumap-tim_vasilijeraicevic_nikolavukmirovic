package dsw.gerumap.app.repository.composite;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MapNode implements IPublisher {
    private String name;
    @ToString.Exclude
    private MapNode parent;
    private List<ISubscriber> subscriberList;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public MapNode(String name, MapNode parent, List<ISubscriber> subscriberList) {
        this.name = name;
        this.parent = parent;
        this.subscriberList = subscriberList;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode) {
            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if (this.getSubscriberList() == null)
            this.setSubscriberList(new ArrayList<>());
        if (this.getSubscriberList().contains(sub))
            return;
        this.getSubscriberList().add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.getSubscriberList() == null || !this.getSubscriberList().contains(sub)) return;
        this.getSubscriberList().remove(sub);
    }

    @Override
    public void notifySubscribers(Object object, Object notification) {
        if (notification == null || this.getSubscriberList() == null || this.getSubscriberList().isEmpty())
            return;

        for (ISubscriber listener : getSubscriberList()) {
            listener.update(object, notification);
        }
    }

    public void setName(String name) {
        this.name = name;
        this.notifySubscribers(this,"RENAME");
    }
}
