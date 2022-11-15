package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.message.MessageGeneratorImplementation;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class DeleteAction extends AbstractGerumapAction {

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.NOTHING_IS_SELECTED);
        } else if (selected.getMapNode() instanceof ProjectExplorer) {
            ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.NODE_CANNOT_BE_DELETED);
        } else {
            MainFrame.getInstance().getMapTree().removeChild(selected);
        }
    }
}
