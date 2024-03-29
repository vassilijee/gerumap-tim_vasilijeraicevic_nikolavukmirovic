package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.Element;

public class ElementFactory extends NodeFactory {
    @Override
    public MapNode createNode(MapNode parent, int count) {
        return new Element("Element " + count, parent);
    }
}
