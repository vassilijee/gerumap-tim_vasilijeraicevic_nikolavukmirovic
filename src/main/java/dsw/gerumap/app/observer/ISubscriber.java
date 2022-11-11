package dsw.gerumap.app.observer;

import dsw.gerumap.app.repository.implementation.Project;

public interface ISubscriber {

    void update(IPublisher iPublisher, Object notification);
}
