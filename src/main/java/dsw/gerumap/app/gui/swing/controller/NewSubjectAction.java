package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class NewSubjectAction extends AbstractGerumapAction {
    public NewSubjectAction() {
        //        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/exit.png"));
        putValue(NAME, "New subject");
        putValue(SHORT_DESCRIPTION, "New subject");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
