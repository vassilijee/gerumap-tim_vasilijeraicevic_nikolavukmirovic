package dsw.gerumap.app.gui.swing.mapRepository.implementation;

import dsw.gerumap.app.gui.swing.mapRepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.mapRepository.composite.MapNodeComposite;

import java.util.List;

public class Project extends MapNodeComposite {
    private String name;

    public Project(List<MapNode> children) {
        super(children);
    }
}
