package dsw.gerumap.app.repository.command;

import dsw.gerumap.app.core.ApplicationFramework;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while (currentCommand < commands.size()){
            commands.remove(currentCommand);
        }
        commands.add(command);
        redoCommand();
    }

    public void redoCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).redoCommand();
            ApplicationFramework.getInstance().getGui().enableUndoAction();
        }
        if(currentCommand == commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand == 0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }
}
