package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class ColorAction extends AbstractGerumapAction{
    public ColorAction() {
        putValue(SMALL_ICON, loadIcon("/images/color.png"));
        putValue(NAME, "Color");
        putValue(SHORT_DESCRIPTION, "Color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
