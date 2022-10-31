package dsw.gerumap.app.repository.implementation;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import java.util.List;

public class ProjectExplorer extends MapNodeComposite {
    public ProjectExplorer(List<MapNode> children) {
        super(children);
    }
}
