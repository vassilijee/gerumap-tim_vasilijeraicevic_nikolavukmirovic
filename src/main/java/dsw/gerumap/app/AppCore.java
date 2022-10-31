package dsw.gerumap.app;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.SwingGui;

// drugacije sve
public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    public static void main(String[] args) {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();
        //!!!!!!!!!!!!!!!!!!!!!!
        //MainFrame mainFrame = MainFrame.getInstance();
        //mainFrame.setVisible(true);
    }

    private AppCore() {
    }

    @Override
    public void run() {
        this.gui.start();
    }

    public static AppCore getInstance() {
        if (instance == null) {
            instance = new AppCore();
        }
        return instance;
    }
}