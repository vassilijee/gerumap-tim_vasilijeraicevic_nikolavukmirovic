package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;

public class MindMapFactory extends NodeFactory{
    @Override
    public MapNode createNode(MapNode parent) {
        return new MindMap("MindMap", parent);
    }
}