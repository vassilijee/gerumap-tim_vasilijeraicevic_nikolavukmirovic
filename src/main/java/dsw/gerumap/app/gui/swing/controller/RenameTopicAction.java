package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class RenameTopicAction extends AbstractGerumapAction{
    public RenameTopicAction() {
        putValue(SMALL_ICON, loadIcon("/images/renameTopic.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
