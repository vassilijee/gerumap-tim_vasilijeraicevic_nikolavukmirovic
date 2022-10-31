package main.java.dsw.gerumap.app.repository.implementation;


import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.List;

public class ProjectExplorer extends MapNodeComposite {
    public ProjectExplorer(List<MapNode> children) {
        super(children);
    }
}
