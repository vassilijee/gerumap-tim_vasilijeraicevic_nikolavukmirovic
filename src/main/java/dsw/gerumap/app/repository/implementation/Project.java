package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.List;

public class Project extends MapNodeComposite {
    private String name;

    public Project(List<MapNode> children) {
        super(children);
    }
}
