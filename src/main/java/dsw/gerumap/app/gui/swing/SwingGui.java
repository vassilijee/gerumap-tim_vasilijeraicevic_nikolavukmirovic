package dsw.gerumap.app.gui.swing;


import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.view.MainFrame;


public class SwingGui implements Gui {
    private MainFrame instance;
    private MapTree a;

    public SwingGui() {
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
