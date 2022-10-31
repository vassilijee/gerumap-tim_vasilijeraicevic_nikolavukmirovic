package dsw.gerumap.app.core;

import lombok.Setter;

@Setter

public class ApplicationFramework {
    protected Gui gui;
    protected MapRepository mapRepository;

    public void run() {
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository) {
        this.gui = gui;
        this.mapRepository = mapRepository;
    }

    private static ApplicationFramework instance;

    private ApplicationFramework() {

    }

    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }
}

