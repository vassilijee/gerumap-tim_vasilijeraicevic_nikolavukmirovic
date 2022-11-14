package dsw.gerumap.app.message;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

public class ConsoleLogger implements ISubscriber {

    @Override
    public void update(IPublisher iPublisher, Object notification) {
        System.out.println(notification.toString());
    }
}
