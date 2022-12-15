package dsw.gerumap.app;

import dsw.gerumap.app.core.*;
import dsw.gerumap.app.errorLogger.ErrorFactory;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.message.MessageGeneratorImplementation;
import dsw.gerumap.app.repository.MapRepositoryImpl;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        ErrorFactory errorFactory = new ErrorFactory();
        ErrorLogger errorLogger = errorFactory.newLogger("ConsoleLogger");
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        messageGenerator.addSubscriber(gui);
        messageGenerator.addSubscriber(errorLogger);
        appCore.initialise(gui, mapRepository, errorLogger, messageGenerator);
        appCore.run();
    }
}
