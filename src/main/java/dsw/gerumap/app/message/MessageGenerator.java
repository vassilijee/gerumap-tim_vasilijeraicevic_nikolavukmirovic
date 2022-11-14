package dsw.gerumap.app.message;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MessageGenerator implements IPublisher {
    private String text;
    private String type;
    private String timeStamp = new SimpleDateFormat("dd.MM.YYYY. HH:mm").format(new java.util.Date());
    private List<ISubscriber> subscriberList;

    private static MessageGenerator instance = null;

    public static MessageGenerator getInstance() {
        if (instance == null) instance = new MessageGenerator();
        return instance;
    }

    public void CantDeleteException(String errMsg) {
        notifySubscribers("[ERROR]" + "[" + timeStamp + "]" + " Ne mozete obrisati selektovani node " + errMsg);
    }

    public void CantRenameException(String errMsg) {
        notifySubscribers("[ERROR]" + "[" + timeStamp + "]" + " Ne mozete preimenovati " + errMsg);
    }


    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if (this.getSubscriberList() == null) this.setSubscriberList(new ArrayList<>());
        if (this.getSubscriberList().contains(sub)) return;
        this.getSubscriberList().add(sub);
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
