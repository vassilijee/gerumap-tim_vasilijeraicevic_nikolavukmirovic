package dsw.gerumap.app;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.repository.MapRepositoryImpl;

// drugacije sve
public class AppCore {
    public static void main(String[] args) {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        MapRepository mapRepository = new MapRepositoryImpl();
        appCore.initialise(gui, mapRepository);
        appCore.run();
    }
}
