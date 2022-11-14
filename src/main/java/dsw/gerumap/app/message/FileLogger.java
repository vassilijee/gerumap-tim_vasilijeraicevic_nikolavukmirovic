package dsw.gerumap.app.message;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ISubscriber {
    @Override
    public void update(IPublisher iPublisher, Object notification) {
        try {
            // ne znam da li je do maca ili do cega ali nemam permission da pisem u fajl
            File file = new File("/log.txt");
            file.setWritable(true);
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(notification.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
