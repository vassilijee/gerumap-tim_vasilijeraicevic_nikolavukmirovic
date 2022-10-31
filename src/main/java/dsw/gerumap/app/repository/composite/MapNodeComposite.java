package main.java.dsw.gerumap.app.repository.composite;

import java.util.List;

public class MapNodeComposite {
    private List<MapNode> children;
    public MapNodeComposite(List<MapNode> children) {
        this.children = children;
    }

    public void addChild(MapNode child) {
        // provera mora
    }

    public void deleteChild(MapNode child) {

    }

    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }
}
