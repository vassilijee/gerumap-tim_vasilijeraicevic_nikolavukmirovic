package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthorAction extends AbstractGerumapAction {

    public AuthorAction() {
        putValue(SMALL_ICON, loadIcon("/images/author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof Project) {
            String text = ((Project) selected.getMapNode()).getAuthor();
            JTextField field = new JTextField(text);
            JOptionPane pane = new JOptionPane(field, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
            JDialog dialog = pane.createDialog("Author");
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
                    MainFrame.getInstance().getMapTree().changeAuthor((Project) selected.getMapNode(), newName);
                }
            }
        } else {
            return;
        }
    }
}
