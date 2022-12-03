package dsw.gerumap.app.observer;

public interface ISubscriber {
    void update(Object publisher, Object notification);
}
