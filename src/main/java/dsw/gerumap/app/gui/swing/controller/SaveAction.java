package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAction extends AbstractGerumapAction{
    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Save action");
        putValue(SHORT_DESCRIPTION, "Save action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        if(!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;
        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;
        if(!project.isChanged()){
            return;
        }
        if(project.getFilePath() == null || project.getFilePath().isEmpty()){
            if (jFileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                projectFile= jFileChooser.getSelectedFile();
                project.setFilePath(project.getFilePath());
            }else {
                return;
            }
        }
        ApplicationFramework.getInstance().getSerializer().saveProject(project);
        project.setChanged(false);

    }
}
