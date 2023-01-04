package dsw.gerumap.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsw.gerumap.app.core.Serializer;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {
    private final Gson gson;
    private final GsonBuilder gsonBuilder = new GsonBuilder();

    public GsonSerializer() {
        gsonBuilder.registerTypeAdapter(MapNode.class, new MapNodeAdapter());
        gson = gsonBuilder.create();
    }

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
    public MindMap loadMindMap(File file) {
        try(FileReader fileReader = new FileReader(file)){
            return gson.fromJson(fileReader, MindMap.class);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project node) {
        try (FileWriter fileWriter = new FileWriter(node.getFilePath() + ".json")) {
            gson.toJson(node, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveMindMap(MindMap node) {
        try(FileWriter fileWriter = new FileWriter(node.getFilePath() + ".json")){
            gson.toJson(node, fileWriter);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
