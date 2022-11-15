package dsw.gerumap.app.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;
import dsw.gerumap.app.message.Message;

public class ConsoleLogger implements ErrorLogger {

    @Override
    public void update(Object object, Object notification) {
        if (notification.equals("ERROR")) {
            Log((Message) object);
        }
    }

    @Override
    public void Log(Message message) {
        System.out.println(message.getText());
    }
}
