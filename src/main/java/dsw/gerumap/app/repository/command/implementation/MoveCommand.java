package dsw.gerumap.app.repository.command.implementation;

import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.MapSelectionModel;
import dsw.gerumap.app.repository.implementation.Topic;

import java.util.HashMap;

public class MoveCommand extends AbstractCommand {
    private final MapSelectionModel mapSelectionModel;
    private final HashMap<String, Integer> cordX;
    private final HashMap<String, Integer> cordY;
    private final HashMap<String, Integer> cordEX;
    private final HashMap<String, Integer> cordEY;

    public MoveCommand(MapSelectionModel mapSelectionModel, HashMap<String, Integer> cordX, HashMap<String, Integer> cordY, HashMap<String, Integer> cordEX, HashMap<String, Integer> cordEY) {
        this.mapSelectionModel = mapSelectionModel;
        this.cordX = new HashMap<>();
        this.cordY = new HashMap<>();
        this.cordEX = new HashMap<>();
        this.cordEY = new HashMap<>();
        this.cordX.putAll(cordX);
        this.cordY.putAll(cordY);
        this.cordEX.putAll(cordEX);
        this.cordEY.putAll(cordEY);
    }

    @Override
    public void undoCommand() {
        for (Element element :
                mapSelectionModel.getSelected()) {
            if (element instanceof Topic) {
                Topic topic = (Topic) element;
                int x;
                int y;
                x = cordX.get(topic.getName());
                y = cordY.get(topic.getName());
                topic.setXY(x, y);
            } else if (element instanceof Link) {
                Link link = (Link) element;
                link.move();
            }
        }
    }

    @Override
    public void redoCommand() {
        for (Element element :
                mapSelectionModel.getSelected()) {
            if (element instanceof Topic) {
                Topic topic = (Topic) element;
                topic.setXY(cordEX.get(topic.getName()), cordEY.get(topic.getName()));
            } else if (element instanceof Link) {
                Link link = (Link) element;
                link.move();
            }
        }
    }
}
