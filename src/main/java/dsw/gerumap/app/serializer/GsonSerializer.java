package dsw.gerumap.app.serializer;

import com.google.gson.Gson;
import dsw.gerumap.app.core.Serializer;
import dsw.gerumap.app.repository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {
    private final Gson gson = new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project node) {
        try (FileWriter fileWriter = new FileWriter(node.getFilePath())) {
            gson.toJson(node, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
