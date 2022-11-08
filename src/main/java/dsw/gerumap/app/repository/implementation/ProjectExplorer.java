package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
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
        System.out.println("dodat" + sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.getSubscriberList() == null || !this.getSubscriberList().contains(sub)) return;
        this.getSubscriberList().remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.getSubscriberList() == null || this.getSubscriberList().isEmpty())
            return;

        for (ISubscriber listener : getSubscriberList()) {
            listener.update(notification);
        }
    }
}
