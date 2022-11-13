package dsw.gerumap.app.observer;


public interface ISubscriber {
    void update(IPublisher iPublisher, Object notification);
}
