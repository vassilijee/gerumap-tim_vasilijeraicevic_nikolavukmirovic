package main.java.dsw.gerumap.app.repository.implementation;


import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.List;

public class Project extends MapNodeComposite {
    private String name;

    public Project(List<MapNode> children) {
        super(children);
    }
}
