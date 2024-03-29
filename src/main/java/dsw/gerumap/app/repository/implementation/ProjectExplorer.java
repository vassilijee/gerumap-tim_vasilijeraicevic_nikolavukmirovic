package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Project) {
            Project project = (Project) child;
            child.setParent(this);
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
                this.notifySubscribers(project, "NEW");
            }
        }
    }
}
