package dsw.gerumap.app;

import dsw.gerumap.app.core.*;
import dsw.gerumap.app.errorLogger.ErrorFactory;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.message.MessageGeneratorImplementation;
import dsw.gerumap.app.repository.MapRepositoryImpl;
import dsw.gerumap.app.serializer.GsonSerializer;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        ErrorFactory errorFactory = new ErrorFactory();
        Serializer serializer = new GsonSerializer();
        ErrorLogger errorLogger = errorFactory.newLogger("ConsoleLogger");
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        messageGenerator.addSubscriber(gui);
        messageGenerator.addSubscriber(errorLogger);
        appCore.initialise(gui, mapRepository, errorLogger, messageGenerator, serializer);
        appCore.run();
    }
}
