package dsw.gerumap.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ActionManager {
    private ExitAction exitAction;
    private NewAction newAction;
    private RenameAction renameAction;
    private DeleteAction deleteAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newAction = new NewAction();
        renameAction = new RenameAction();
        deleteAction = new DeleteAction();
    }
}
