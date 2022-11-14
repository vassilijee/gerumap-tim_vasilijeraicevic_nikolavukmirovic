package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class RenameAction extends AbstractGerumapAction {
    public RenameAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/rename.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if (selected == null) {
        } else {
            String text = selected.toString();
            JTextField field = new JTextField(text, 20);
            JOptionPane pane = new JOptionPane(field, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
            JDialog dialog = pane.createDialog("Rename");
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    field.requestFocus();
                    field.selectAll();
                }
            });
            dialog.setVisible(true);
            dialog.dispose();
            Object value = pane.getValue();
            if (value instanceof Integer) {
                int result = (int) value;
                if (result == JOptionPane.OK_OPTION) {
                    String newName = field.getText();
                    MainFrame.getInstance().getMapTree().renameChild(selected, newName);
                }
            }
        }
    }
}
