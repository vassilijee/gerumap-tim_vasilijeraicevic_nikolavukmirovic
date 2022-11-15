package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Project extends MapNodeComposite {
    private String author = "/";

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof MindMap) {
            MindMap map = (MindMap) child;
            if (!this.getChildren().contains(map)) {
                this.getChildren().add(map);
                this.notifySubscribers(map, "NEW");
            }
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        this.notifySubscribers(this, "AUTHOR");
    }
}
