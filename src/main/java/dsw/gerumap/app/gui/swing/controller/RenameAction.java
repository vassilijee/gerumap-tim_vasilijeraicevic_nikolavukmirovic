package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class RenameAction extends AbstractGerumapAction{
    public RenameAction(){
        putValue(SMALL_ICON, loadIcon("/images/rename.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
