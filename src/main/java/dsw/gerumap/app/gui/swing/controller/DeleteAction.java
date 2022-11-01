package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractGerumapAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        //putValue(SMALL_ICON);
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }
}
