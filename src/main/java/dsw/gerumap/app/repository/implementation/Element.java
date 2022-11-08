package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

public class Element extends MapNode {
    private List<ISubscriber> subscribers = getSubscriberList();
    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {

        if (sub == null) return;
        if (this.getSubscriberList() == null) this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub)) return;
        this.subscribers.add(sub);
        System.out.println("dodat" + sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.subscribers == null || !this.subscribers.contains(sub)) return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {

    }
}
