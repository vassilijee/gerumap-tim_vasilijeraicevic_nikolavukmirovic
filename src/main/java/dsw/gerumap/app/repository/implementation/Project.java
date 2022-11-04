package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {
    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof MindMap) {
            MindMap map = (MindMap) child;
            if (this.getChildren().contains(map)) {
                this.getChildren().add(map);
            }
        }
    }
}
