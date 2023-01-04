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


        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap))
            return;

        MindMap mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File mindMapFile;
        if (!mindMap.isTemplate()) {
            return;
        }
        if (mindMap.getFilePath() == null || mindMap.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                mindMapFile = jfc.getSelectedFile();
                mindMap.setFilePath(mindMapFile.getPath());
            } else {
                return;
            }
        }
        mindMap.setName("Template " + count);
        count++;
        ApplicationFramework.getInstance().getSerializer().saveMindMap(mindMap);
        mindMap.setTemplate(false);
    }
}
