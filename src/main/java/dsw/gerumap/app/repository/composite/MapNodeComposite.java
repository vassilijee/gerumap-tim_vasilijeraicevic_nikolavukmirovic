package dsw.gerumap.app.repository.composite;

import dsw.gerumap.app.observer.ISubscriber;
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

    public void removeChild(MapNode child){
        children.remove(child);
        this.notifySubscribers(this,"DELETE");
    }

    public MapNode getChildByName(String name) {
        for (MapNode child : this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return this;
    }

    public MapNode getChildByIndex(int index) {
        List<MapNode> children = this.getChildren();
        for (int i = 0; i < children.size(); i++) {
            if (i == index) {
                return children.get(i);
            }
        }
        return this;
    }
}
