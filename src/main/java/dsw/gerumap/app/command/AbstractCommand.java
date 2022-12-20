package dsw.gerumap.app.command;

public abstract class AbstractCommand {
    public abstract void undoCommand();
    public abstract void redoCommand();
}
