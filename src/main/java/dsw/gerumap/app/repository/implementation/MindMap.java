package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.List;

public class MindMap extends MapNodeComposite {
    public MindMap(List<MapNode> children) {
        super(children);
    }
}
