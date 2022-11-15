package dsw.gerumap.app.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationFramework {
    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;
    protected MessageGenerator messageGenerator;

    public void run() {
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository, ErrorLogger errorLogger, MessageGenerator messageGenerator) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.errorLogger = errorLogger;
        this.messageGenerator = messageGenerator;
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

