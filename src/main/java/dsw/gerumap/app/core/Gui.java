package dsw.gerumap.app.core;

import dsw.gerumap.app.command.CommandManager;
import dsw.gerumap.app.observer.ISubscriber;

public interface Gui extends ISubscriber {
    void start();
    void disableUndoAction();
    void disableRedoAction();
    void enableUndoAction();
    void enableRedoAction();

    CommandManager getCommandManager();
}
