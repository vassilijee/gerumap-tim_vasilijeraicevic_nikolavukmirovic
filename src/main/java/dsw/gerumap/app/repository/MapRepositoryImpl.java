package dsw.gerumap.app.repository;

import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {
    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild1(MapNodeComposite parent, MapNode child) {
        parent.addChild(child);
    }
}
