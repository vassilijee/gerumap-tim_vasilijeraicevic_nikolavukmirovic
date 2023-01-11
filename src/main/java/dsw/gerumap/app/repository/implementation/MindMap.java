package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.command.CommandManager;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MindMap extends MapNodeComposite {
     protected boolean template = true;
     protected String filePath;
     private CommandManager commandManager;
    public MindMap(String name, MapNode parent) {
        super(name, parent);
        this.commandManager = new CommandManager();
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Element) {
            Element element = (Element) child;
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                this.notifySubscribers(element, "NEW");
            }
        }
    }
}
