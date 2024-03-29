package dsw.gerumap.app.repository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MapNodeComposite extends MapNode {
    private List<MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public abstract void addChild(MapNode child);

    public void removeChild(MapNode child) {
        this.notifySubscribers(child, "DELETE");
        children.remove(child);
    }

    public MapNode getChildByName(String name) {
        for (MapNode child : this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return this;
    }
}
