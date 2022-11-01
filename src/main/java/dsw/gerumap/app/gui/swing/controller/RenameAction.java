package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class RenameAction extends AbstractGerumapAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        //putValue(SMALL_ICON);
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }
}
