package main.java.dsw.gerumap.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
    }

}
