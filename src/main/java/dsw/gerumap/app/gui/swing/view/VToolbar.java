package dsw.gerumap.app.gui.swing.view;


import javax.swing.*;

public class VToolbar extends JToolBar {
    public VToolbar() {
        super(JToolBar.VERTICAL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(MainFrame.getInstance().getActionManager().getElementSelectionAction());
        add(MainFrame.getInstance().getActionManager().getMoveElementAction());
        add(MainFrame.getInstance().getActionManager().getNewSubjectAction());
        add(MainFrame.getInstance().getActionManager().getNewLinkAction());
    }
}
