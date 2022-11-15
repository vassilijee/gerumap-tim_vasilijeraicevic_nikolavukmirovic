package dsw.gerumap.app.core;

import dsw.gerumap.app.message.Message;
import dsw.gerumap.app.observer.ISubscriber;

public interface ErrorLogger extends ISubscriber {
    void Log(Message message);
}
