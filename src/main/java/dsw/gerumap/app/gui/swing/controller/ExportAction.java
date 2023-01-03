package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ExportAction extends AbstractGerumapAction {
    public ExportAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(NAME, "Export");
        putValue(SHORT_DESCRIPTION, "Export");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int index = MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
        MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getComponentAt(index);
        String name = mindMapView.getName();

        BufferedImage image = new BufferedImage(mindMapView.getWidth(), mindMapView.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        mindMapView.paint(g2);
        try {
            ImageIO.write(image, "png", new File(name + "." + "png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
