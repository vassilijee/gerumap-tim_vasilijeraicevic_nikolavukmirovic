package dsw.gerumap.app.gui.swing.tree;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class MapTreeImplementation implements MapTree {
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    private static int projectCount = 0;
    private static int mapCount;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(MapTreeItem child) {
        //mapCount--;
        treeModel.removeNodeFromParent(child);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void renameChild(MapTreeItem child, String newName) {
        child.setName(newName);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer) {
            return new Project("Project " + ProjectCount(), parent);
        } else if (parent instanceof Project) {
            mapCount = this.getSelectedNode().getChildCount();
            return new MindMap("MindMap " + mapCount, parent);
        } else {
            return null;
        }
    }

    private int ProjectCount(){
        projectCount++;
        return projectCount;
    }
}
