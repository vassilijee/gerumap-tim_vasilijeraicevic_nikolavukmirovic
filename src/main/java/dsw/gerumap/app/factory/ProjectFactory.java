package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.Project;

public class ProjectFactory extends NodeFactory{
    private int projectCount = 0;
    @Override
    public MapNode createNode(MapNode parent) {
        return new Project("Project", parent);
    }
}
