package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {
    private boolean template = false;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if (this.getSubscriberList() == null)
            this.setSubscriberList(new ArrayList<>());
        if (this.getSubscriberList().contains(sub))
            return;
        this.getSubscriberList().add(sub);
        System.out.println("dodat" + sub);
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
            listener.update(notification);
        }
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Element) {
            Element element = (Element) child;
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
        }
    }
}
