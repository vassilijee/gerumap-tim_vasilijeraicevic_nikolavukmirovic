package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class NewLinkAction extends AbstractGerumapAction {
    public NewLinkAction() {

//        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/newLink.png"));
        putValue(NAME, "New link");
        putValue(SHORT_DESCRIPTION, "New link");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddLinkState();
        System.out.println("Add link state");
    }
}
