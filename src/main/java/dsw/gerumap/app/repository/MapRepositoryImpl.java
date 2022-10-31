package dsw.gerumap.app.repository;

import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {
    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("MyProjectExplorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return null;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        // implement add child method
    }
}
