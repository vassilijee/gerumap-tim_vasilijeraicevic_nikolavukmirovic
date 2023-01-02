package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.repository.implementation.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StrokeAction extends AbstractGerumapAction {
    public StrokeAction() {
        putValue(SMALL_ICON, loadIcon("/images/stroke.png"));
        putValue(NAME, "Stroke");
        putValue(SHORT_DESCRIPTION, "Stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField textField = new JTextField();
        JOptionPane pane = new JOptionPane(textField, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
        JDialog dialog = pane.createDialog("Stroke");
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                textField.requestFocus();
                textField.selectAll();
            }
        });
        dialog.setVisible(true);
        dialog.dispose();
        Object value = pane.getValue();
        String text = textField.getText();
        int index = MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
        MindMapView mindMapView = null;
        if(index > -1){
            mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getComponentAt(index);
        }
        if (value instanceof Integer) {
            int result = (int) value;
            if (result == JOptionPane.OK_OPTION) {
                if (mindMapView != null) {
                    if (!(mindMapView.getMapSelectionModel().getSelected().isEmpty())) {
                        for (Element element :
                                mindMapView.getMapSelectionModel().getSelected()) {
                            element.setStroke(Integer.parseInt(text));
                        }
                        mindMapView.getMapSelectionModel().clearSelectedColorStroke();
                    } else {
                        Element.setStroke1(Integer.parseInt(text));
                    }
                }
            }
        }
    }
}
