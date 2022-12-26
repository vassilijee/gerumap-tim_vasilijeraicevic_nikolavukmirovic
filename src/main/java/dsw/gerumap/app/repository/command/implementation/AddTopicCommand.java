package dsw.gerumap.app.repository.command.implementation;

import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Topic;

public class AddTopicCommand extends AbstractCommand {
    private Topic topic;
    private MindMap mindMap;

    public AddTopicCommand(Topic topic, MindMap mindMap) {
        this.topic = topic;
        this.mindMap = mindMap;
    }

    @Override
    public void undoCommand() {
        mindMap.removeChild(topic);
    }

    @Override
    public void redoCommand() {
        mindMap.addChild(topic);
    }
}
