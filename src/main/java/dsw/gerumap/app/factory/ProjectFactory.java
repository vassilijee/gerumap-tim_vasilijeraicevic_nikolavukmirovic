package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.Project;

public class ProjectFactory extends NodeFactory {
    @Override
    public MapNode createNode(MapNode parent, int count) {
        return new Project("Project " + count, parent);
    }
}
