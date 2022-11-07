package dsw.gerumap.app.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);
}
