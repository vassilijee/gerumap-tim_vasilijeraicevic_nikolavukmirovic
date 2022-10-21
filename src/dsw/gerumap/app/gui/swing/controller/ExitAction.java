package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractGerumapAction {

    public ExitAction() {
        //BRATE NECE ACCELATOR_KEY DA UCITA I SMALL_ICON BUDE CRVENO
        //putValue(ACCELATOR_KEY, KeyStroke.getKeyStroke(
        //        KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        //putValue(SAMLL_ICON, loadIcon("images/log-out.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
