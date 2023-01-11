package dsw.gerumap.app.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;
import dsw.gerumap.app.message.Message;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ErrorLogger {
    public File file = new File("src/main/resources/log.txt");

    @Override
    public void update(Object object, Object notification) {
        if (notification.equals("ERROR")) {
            Log((Message) object);
        }
    }

    @Override
    public void Log(Message message) {
        try {
            FileWriter myWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.append(message.getText());
            bufferedWriter.append("\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
