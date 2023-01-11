package dsw.gerumap.app.repository.command;

public abstract class AbstractCommand {
    public abstract void undoCommand();
    public abstract void redoCommand();
}
