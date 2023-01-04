package dsw.gerumap.app.gui.swing.controller;

import com.sun.tools.javac.Main;
import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class NewAction extends AbstractGerumapAction {
    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (!(selected == null)) {
            if (selected.getMapNode() instanceof MindMap) {
                ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.CHILD_CANNOT_BE_ADDED);
            }else if(selected.getMapNode() instanceof Project){
                JLabel label = new JLabel("Da li zelite da ucitate sablon?");
                JOptionPane pane = new JOptionPane(label, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null);
                JDialog dialog = pane.createDialog("Template");
                dialog.setVisible(true);
                dialog.dispose();
                Object value = pane.getValue();
                if (value instanceof Integer) {
                    int result = (int) value;
                    if (result == JOptionPane.OK_OPTION) {
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.setCurrentDirectory(new File("src/main/resources/templates/"));
                        if (jFileChooser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                            try {
                                File file = jFileChooser.getSelectedFile();
                                MindMap mindMap = ApplicationFramework.getInstance().getSerializer().loadMindMap(file);
                                MainFrame.getInstance().getMapTree().loadMindMap(mindMap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        MainFrame.getInstance().getMapTree().addChild(selected);
                    }
                }

            }else if(selected.getMapNode() instanceof ProjectExplorer){
                MainFrame.getInstance().getMapTree().addChild(selected);
            }
        } else {
            ApplicationFramework.getInstance().getMessageGenerator().generate(EventType.NOTHING_IS_SELECTED);
        }
    }
}
