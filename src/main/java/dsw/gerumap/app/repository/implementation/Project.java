package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Project extends MapNodeComposite {
    private String author;
    protected boolean changed = true;
    protected String filePath;

    public Project(String name, MapNode parent) {
        super(name, parent);
        this.author = "/";
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof MindMap) {
            MindMap map = (MindMap) child;
            if (!this.getChildren().contains(map)) {
                this.getChildren().add(map);
                map.setParent(this);
                this.notifySubscribers(map, "NEW");
            }
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        this.notifySubscribers(this, "AUTHOR");
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
    }
}
