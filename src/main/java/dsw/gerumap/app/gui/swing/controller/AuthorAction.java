package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class AuthorAction extends AbstractGerumapAction{

    public AuthorAction() {
        putValue(SMALL_ICON, loadIcon("/images/author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
