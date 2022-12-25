package dsw.gerumap.app.core;

import dsw.gerumap.app.repository.implementation.Project;

import java.io.File;

public interface Serializer {
    Project loadProject(File file);
    void saveProject(Project node);
}
