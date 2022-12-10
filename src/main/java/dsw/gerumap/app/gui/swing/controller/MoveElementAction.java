package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class MoveElementAction extends AbstractGerumapAction {
    public MoveElementAction() {
        //        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/exit.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
