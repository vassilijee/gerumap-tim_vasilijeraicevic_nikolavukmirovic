package dsw.gerumap.app.message;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MessageGeneratorImplementation implements MessageGenerator {
    private String text;
    private String type;
    private String timeStamp = new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(new java.util.Date());
    private List<ISubscriber> subscriberList;

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
    public void notifySubscribers(Object object, Object notification) {
        if (notification == null || this.getSubscriberList() == null || this.getSubscriberList().isEmpty()) return;

        for (ISubscriber listener : getSubscriberList()) {
            listener.update(object, notification);
        }
    }

    @Override
    public void generate(EventType eventType) {
        if(eventType.equals(EventType.NAME_CANNOT_BE_EMPTY)){
            this.notifySubscribers(new Message("[ERROR] [" + timeStamp + "] Polje za ime ne moze biti prazno."), "ERROR");
        }else if(eventType.equals(EventType.AUTHOR_CANNOT_BE_ADDED)){
            this.notifySubscribers(new Message("[ERROR] [" + timeStamp + "] Cvor ne moze imati autora"), "ERROR");
        }else if(eventType.equals(EventType.CHILD_CANNOT_BE_ADDED)){
            this.notifySubscribers(new Message("[ERROR] [" + timeStamp + "] Cvor ne moze imati dete"), "ERROR");
        }else if(eventType.equals(EventType.NODE_CANNOT_BE_DELETED)){
            this.notifySubscribers(new Message("[ERROR] [" + timeStamp + "] Cvor ne moze biti obrisan"), "ERROR");
        }else if(eventType.equals(EventType.NOTHING_IS_SELECTED)){
            this.notifySubscribers(new Message("[ERROR] [" + timeStamp + "] Nista nije selektovano"), "ERROR");
        }
    }
}
