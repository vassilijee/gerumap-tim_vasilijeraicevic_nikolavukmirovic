package dsw.gerumap.app.repository.command.implementation;



import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.MapSelectionModel;
import dsw.gerumap.app.repository.implementation.MindMap;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand extends AbstractCommand {
    private MindMap mindMap;
    private List<Element> selected;
    private MapSelectionModel mapSelectionModel;

    public DeleteCommand(MindMap mindMap, List<Element> selected, MapSelectionModel mapSelectionModel) {
        this.mindMap = mindMap;
        this.selected = new ArrayList<>();
        this.selected.addAll(selected);
        this.mapSelectionModel = mapSelectionModel;
    }

    @Override
    public void undoCommand() {
        for (Element element:
             selected) {
            mindMap.addChild(element);
        }
    }

    @Override
    public void redoCommand() {
        mapSelectionModel.getSelected().addAll(selected);
        mapSelectionModel.clearSelected();
    }
}
