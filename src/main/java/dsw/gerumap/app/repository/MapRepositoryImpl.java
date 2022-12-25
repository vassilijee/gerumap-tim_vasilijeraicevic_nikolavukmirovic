package dsw.gerumap.app.repository;

import dsw.gerumap.app.command.CommandManager;
import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {
    private ProjectExplorer projectExplorer;
    private CommandManager commandManager;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
        commandManager = new CommandManager();
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        parent.addChild(child);
        // System.out.println("repository: " + parent.getName() + " ---> " +
        // child.getName());
    }
}
