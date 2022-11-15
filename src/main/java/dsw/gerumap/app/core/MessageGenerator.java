package dsw.gerumap.app.core;

import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.observer.IPublisher;

public interface MessageGenerator extends IPublisher {
    void generate(EventType eventType);
}
