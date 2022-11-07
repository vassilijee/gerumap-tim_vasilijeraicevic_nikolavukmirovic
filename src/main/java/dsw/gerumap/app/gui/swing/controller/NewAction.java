package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractGerumapAction {
    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if(selected == null){
            return;
        }else{
            MainFrame.getInstance().getMapTree().addChild(selected);
        }
    }
}
