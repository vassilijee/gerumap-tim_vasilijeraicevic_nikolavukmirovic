package dsw.gerumap.app.core;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public interface MapRepository {
    ProjectExplorer getProjectExplorer();

    void addChild1(MapNodeComposite parent, MapNode child);
}
