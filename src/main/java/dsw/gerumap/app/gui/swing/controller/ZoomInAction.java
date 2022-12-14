package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractGerumapAction {
    public ZoomInAction() {
        //        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/zoom.png"));
        putValue(NAME, "Zoom");
        putValue(SHORT_DESCRIPTION, "Zoom");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startZoomState();
        MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
        double zoomIn = mindMapView.getZoom() + 0.1;
        mindMapView.setZoom(zoomIn);
        mindMapView.repaint();
    }
}
