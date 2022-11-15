package dsw.gerumap.app.gui.swing.tree;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.factory.GenFactory;
import dsw.gerumap.app.factory.NodeFactory;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
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
        ApplicationFramework.getInstance().getMapRepository().addChild((MapNodeComposite) parent.getMapNode(), child);
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(MapTreeItem child) {
        child.removeFromParent();
        ((MapNodeComposite) child.getMapNode().getParent()).removeChild(child.getMapNode());
        SwingUtilities.updateComponentTreeUI(treeView);
        MainFrame.getInstance().getProjectExplorer().setSelectionPath(null);
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
        int count = this.getSelectedNode().getChildCount();
        NodeFactory nodeFactory = GenFactory.generateFactory(parent);
        MapNode node = nodeFactory.createNode(parent, count);
        return node;
    }

    private int projectCount() {
        projectCount++;
        return projectCount;
    }
}
