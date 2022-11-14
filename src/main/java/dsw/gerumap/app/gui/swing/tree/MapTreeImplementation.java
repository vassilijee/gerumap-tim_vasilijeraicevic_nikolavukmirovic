package dsw.gerumap.app.gui.swing.tree;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MapTreeImplementation implements MapTree {
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    private static int projectCount = 0;


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

    @Override
    public List<TreeNode> getChildren(MapTreeItem parent) {
        List<TreeNode> children = new ArrayList<>();
        for (int i = 0; i < parent.getChildCount(); i++) {
            children.set(i, parent.getChildAt(i));
        }
        return children;
    }

    @Override
    public void expandPath() {
        this.treeView.expandPath(treeView.getSelectionPath());
    }

    @Override
    public void changeAuthor(Project child, String author) {
        child.setAuthor(author);
    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer) {
            return new Project("Project " + projectCount(), parent);
        } else if (parent instanceof Project) {
            int mapCount = this.getSelectedNode().getChildCount();
            return new MindMap("MindMap " + mapCount, parent);
        } else if (parent instanceof MindMap) {
            int elementCount = this.getSelectedNode().getChildCount();
            return new Element("Element " + elementCount, parent);
        } else {
            return null;
        }
    }

    private int projectCount() {
        projectCount++;
        return projectCount;
    }
}
