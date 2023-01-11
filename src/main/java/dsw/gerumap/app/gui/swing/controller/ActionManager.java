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
    private DeleteElementAction deleteElementAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private ColorAction colorAction;
    private StrokeAction strokeAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveAction saveAction;
    private OpenAction openAction;
    private RenameTopicAction renameTopicAction;
    private ExportAction exportAction;
    private TemplateAction templateAction;
    private SaveAsAction saveAsAction;

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
        deleteElementAction = new DeleteElementAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        colorAction = new ColorAction();
        strokeAction = new StrokeAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        openAction = new OpenAction();
        saveAction = new SaveAction();
        renameTopicAction = new RenameTopicAction();
        exportAction = new ExportAction();
        templateAction = new TemplateAction();
        saveAsAction = new SaveAsAction();
    }
}
