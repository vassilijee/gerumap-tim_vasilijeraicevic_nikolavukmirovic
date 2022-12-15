package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapSelectionModel implements IPublisher {
    private List<Element> selected = new ArrayList<>();
    private List<ISubscriber> subscriberList;

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null)
            return;
        if (this.getSubscriberList() == null)
            this.setSubscriberList(new ArrayList<>());
        if (this.getSubscriberList().contains(sub))
            return;
        this.getSubscriberList().add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || this.getSubscriberList() == null || !this.getSubscriberList().contains(sub))
            return;
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

    public void clearSelected(){
        this.selected.clear();
        this.notifySubscribers(this, "REPAINT");
    }

}
