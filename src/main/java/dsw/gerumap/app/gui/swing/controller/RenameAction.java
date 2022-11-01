package dsw.gerumap.app.gui.swing.controller;


import java.awt.event.ActionEvent;


public class RenameAction extends AbstractGerumapAction{
    public RenameAction(){
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/rename.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
