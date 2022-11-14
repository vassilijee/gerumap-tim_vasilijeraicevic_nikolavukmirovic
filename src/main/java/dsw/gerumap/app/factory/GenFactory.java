package dsw.gerumap.app.factory;

import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class GenFactory {
    public static NodeFactory generateFactory(Object obj) {
        if (obj instanceof ProjectExplorer)
            return new ProjectFactory();
        if (obj instanceof Project)
            return new MindMapFactory();
        if (obj instanceof MindMap)
            return new ElementFactory();
        return null;
    }
}
