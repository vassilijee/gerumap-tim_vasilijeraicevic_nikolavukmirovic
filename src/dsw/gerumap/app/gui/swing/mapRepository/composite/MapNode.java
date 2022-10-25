package dsw.gerumap.app.gui.swing.mapRepository.composite;

public class MapNode {
    private String name;
    private MapNode parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
