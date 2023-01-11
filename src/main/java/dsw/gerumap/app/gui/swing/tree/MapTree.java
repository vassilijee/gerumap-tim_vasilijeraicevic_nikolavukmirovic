package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

public interface MapTree {
    MapTreeView generateTree(ProjectExplorer projectExplorer);

    void addChild(MapTreeItem parent);

    void removeChild(MapTreeItem child);

    void renameChild(MapTreeItem child, String newName);

    void expandPath();

    void changeAuthor(Project child, String author);

    MapTreeItem getSelectedNode();

    void loadProject(Project node);
    void loadMindMap(MindMap node);
}
