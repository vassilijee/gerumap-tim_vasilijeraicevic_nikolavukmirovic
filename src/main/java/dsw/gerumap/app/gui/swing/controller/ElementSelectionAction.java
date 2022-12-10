package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;


public class ElementSelectionAction extends AbstractGerumapAction{
    public ElementSelectionAction() {
//        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/exit.png"));
        putValue(NAME, "Selection");
        putValue(SHORT_DESCRIPTION, "Selection");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
