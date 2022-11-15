package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
                this.notifySubscribers(project, "NEW");
            }

        }
    }
}
