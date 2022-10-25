package dsw.gerumap.app.gui.swing.controller;

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    public ActionManager() {
       initActions();
    }

    private void initActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
    }

    public ExitAction getExitAction(){
        return exitAction;
    }

    public NewProjectAction getNewProjectAction(){
        return newProjectAction;
    }
}
