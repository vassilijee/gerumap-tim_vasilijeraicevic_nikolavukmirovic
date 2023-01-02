package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class VToolbar extends JToolBar {
    public VToolbar() {
        super(JToolBar.VERTICAL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(MainFrame.getInstance().getActionManager().getNewSubjectAction());
        add(MainFrame.getInstance().getActionManager().getNewLinkAction());
        add(MainFrame.getInstance().getActionManager().getElementSelectionAction());
        add(MainFrame.getInstance().getActionManager().getDeleteElementAction());
        add(MainFrame.getInstance().getActionManager().getMoveElementAction());
        add(MainFrame.getInstance().getActionManager().getZoomInAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        add(MainFrame.getInstance().getActionManager().getColorAction());
        add(MainFrame.getInstance().getActionManager().getStrokeAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getRenameTopicAction());
    }
}
