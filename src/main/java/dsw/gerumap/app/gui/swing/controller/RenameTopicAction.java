package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.repository.implementation.Topic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RenameTopicAction extends AbstractGerumapAction {
    public RenameTopicAction() {
        putValue(SMALL_ICON, loadIcon("/images/renameTopic.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
        MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getComponentAt(index);

        if (mindMapView.getMapSelectionModel().getSelected().size() != 1) {
            System.out.print("Selektovali ste vise od jenog elementa ili niste selektovali element");
            mindMapView.getMapSelectionModel().clearSelectedColorStroke();
        } else if(mindMapView.getMapSelectionModel().getSelected().get(0) instanceof Topic){
            String text = mindMapView.getMapSelectionModel().getSelected().get(0).getName();
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
                    if (newName.equals("")) {
                        ApplicationFramework.getInstance().getMessageGenerator()
                                .generate(EventType.NAME_CANNOT_BE_EMPTY);
                    } else {
                        // mora provera da li vec postoji isto ime
                        mindMapView.getMapSelectionModel().getSelected().get(0).setName(newName);
                        mindMapView.getMapSelectionModel().clearSelectedColorStroke();
                    }
                }
            }else{
                System.out.println("Niste selektovali Topic");
                mindMapView.getMapSelectionModel().clearSelectedColorStroke();
            }
        }
    }
}
