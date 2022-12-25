package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.command.CommandManager;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.message.Message;

import javax.swing.*;

public class SwingGui implements Gui {
    private MainFrame instance;

    private CommandManager commandManager;

    public SwingGui() {
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        commandManager = new CommandManager();
        disableRedoAction();
        disableUndoAction();
        instance.setVisible(true);
    }

    @Override
    public void update(Object object, Object notification) {
        if (notification.equals("ERROR")) {
            JOptionPane optionPane = new JOptionPane(((Message) object).getText(), JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = optionPane.createDialog("ERROR");
            dialog.setVisible(true);
            dialog.dispose();
        }
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }
}
