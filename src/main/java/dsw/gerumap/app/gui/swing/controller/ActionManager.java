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
    private InfoAction infoAction;
    private AuthorAction authorAction;

    private ElementSelectionAction elementSelectionAction;
    private MoveElementAction moveElementAction;
    private NewSubjectAction newSubjectAction;
    private NewLinkAction newLinkAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newAction = new NewAction();
        renameAction = new RenameAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
        elementSelectionAction = new ElementSelectionAction();
        moveElementAction = new MoveElementAction();
        newSubjectAction = new NewSubjectAction();
        newLinkAction = new NewLinkAction();
    }
}
