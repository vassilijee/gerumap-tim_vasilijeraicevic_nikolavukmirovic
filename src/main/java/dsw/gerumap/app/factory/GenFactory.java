package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class GenFactory {
    private static NodeFactory node;

    public static NodeFactory generateFactory(Object obj) {
        if (obj instanceof ProjectExplorer)
            node = new ProjectFactory();
        if (obj instanceof Project)
            node = new MindMapFactory();
        if (obj instanceof MindMap)
            node = new ElementFactory();
        return node;
    }
}
