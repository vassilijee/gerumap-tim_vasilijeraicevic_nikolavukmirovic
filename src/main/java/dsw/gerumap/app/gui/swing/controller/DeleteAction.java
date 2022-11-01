package dsw.gerumap.app.gui.swing.controller;


import java.awt.event.ActionEvent;



public class DeleteAction extends AbstractGerumapAction{

    public DeleteAction(){
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
