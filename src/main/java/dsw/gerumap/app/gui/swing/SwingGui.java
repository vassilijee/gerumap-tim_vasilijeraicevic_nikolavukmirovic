package main.java.dsw.gerumap.app.gui.swing;


import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {
    @Override
    public void start() {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
