package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.repository.implementation.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorAction extends AbstractGerumapAction {
    public ColorAction() {
        putValue(SMALL_ICON, loadIcon("/images/color.png"));
        putValue(NAME, "Color");
        putValue(SHORT_DESCRIPTION, "Color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JColorChooser jColorChooser = new JColorChooser();
        JOptionPane pane = new JOptionPane(jColorChooser, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
        JDialog dialog = pane.createDialog("Color");
        dialog.setVisible(true);
        dialog.dispose();
        Object value = pane.getValue();
        Color color = jColorChooser.getColor();
        int index = MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
        MindMapView mindMapView = null;
        if (index > -1) {
            mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getComponentAt(index);
        }
        if (value instanceof Integer) {
            int result = (int) value;
            if (result == JOptionPane.OK_OPTION) {
                if (mindMapView != null) {
                    if (!(mindMapView.getMapSelectionModel().getSelected().isEmpty())) {
                        for (Element element :
                                mindMapView.getMapSelectionModel().getSelected()) {
                            element.setColor(color);
                        }
                        mindMapView.getMapSelectionModel().clearSelectedColorStroke();
                    } else {
                        Element.setColor1(color);
                    }
                }
            }
        }
    }
}
