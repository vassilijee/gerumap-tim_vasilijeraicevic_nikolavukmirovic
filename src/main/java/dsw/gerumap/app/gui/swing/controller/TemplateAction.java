package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class TemplateAction extends AbstractGerumapAction{
    private static int count = 0;
    public TemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/template.png"));
        putValue(NAME, "Template mindmap");
        putValue(SHORT_DESCRIPTION, "Template mindmap");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.json", "json");
        jfc.setFileFilter(filter);
        jfc.setCurrentDirectory(new File("src/main/resources/templates/"));


        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap))
            return;

        MindMap mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        if (!mindMap.isTemplate()) {
            return;
        }
        if (mindMap.getFilePath() == null || mindMap.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                File mindMapFile = new File(jfc.getSelectedFile()+"");
                mindMap.setFilePath(mindMapFile.getPath());
                mindMap.setName(jfc.getSelectedFile().getName());
            } else {
                return;
            }
        }
        ApplicationFramework.getInstance().getSerializer().saveMindMap(mindMap);
        mindMap.setTemplate(false);
    }
}
