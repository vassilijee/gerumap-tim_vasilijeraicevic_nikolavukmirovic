package dsw.gerumap.app.repository.command.implementation;

import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.MapSelectionModel;
import dsw.gerumap.app.repository.implementation.Topic;

import java.util.HashMap;

public class MoveCommand extends AbstractCommand {
    private MapSelectionModel mapSelectionModel;
    private HashMap<String, Integer> cordX;
    private HashMap<String, Integer> cordY;
    private int x1, y1;

    public MoveCommand(MapSelectionModel mapSelectionModel, HashMap<String, Integer> cordX, HashMap<String, Integer> cordY, int x1, int y1) {
        this.mapSelectionModel = mapSelectionModel;
        this.cordX = new HashMap<>();
        this.cordY = new HashMap<>();
        this.cordX.putAll(cordX);
        this.cordY.putAll(cordY);
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void undoCommand() {
        for (Element element:
             mapSelectionModel.getSelected()) {
            if(element instanceof Topic){
                Topic topic = (Topic) element;
                int x;
                int y;
                x = cordX.get(topic.getName());
                System.out.println(x);
                y = cordY.get(topic.getName());
                System.out.println(y);
                topic.setXY(x, y);
            }else if(element instanceof Link){
                Link link = (Link) element;
                link.move();
            }
        }
    }

    @Override
    public void redoCommand() {
        for (Element element:
             mapSelectionModel.getSelected()) {
            if(element instanceof Topic){
                Topic topic = (Topic) element;
                topic.setXY(x1, y1);
            }else if(element instanceof Link){
                Link link = (Link) element;
                link.move();
            }
        }
    }
}
