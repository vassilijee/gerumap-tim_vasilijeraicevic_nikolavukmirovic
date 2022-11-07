package dsw.gerumap.app.repository.composite;

import dsw.gerumap.app.observer.IPublisher;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class MapNode implements IPublisher {
    private String name;
    @ToString.Exclude
    private MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MapNode) {
            MapNode otherObj = (MapNode) o;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
}
