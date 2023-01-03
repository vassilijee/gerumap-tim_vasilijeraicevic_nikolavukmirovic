package dsw.gerumap.app.repository.command.implementation;

import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.implementation.Link;
import dsw.gerumap.app.repository.implementation.MindMap;

public class AddLinkCommand extends AbstractCommand {
    private final Link link;
    private final MindMap mindMap;

    public AddLinkCommand(Link link, MindMap mindMap) {
        this.link = link;
        this.mindMap = mindMap;
    }

    @Override
    public void undoCommand() {
        mindMap.removeChild(link);
    }

    @Override
    public void redoCommand() {
        mindMap.addChild(link);
    }
}
