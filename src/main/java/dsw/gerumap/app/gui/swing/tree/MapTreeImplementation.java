package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.factory.GenFactory;
import dsw.gerumap.app.factory.NodeFactory;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeModel;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.Project;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;

public class MapTreeImplementation implements MapTree {
    private MapTreeView treeView;
    private MapTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MapTreeModel(root);
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
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);
        treeModel.getRoot().add(loadedProject);
        MapNodeComposite mapNodeComposite = (MapNodeComposite)treeModel.getRoot().getMapNode();
        mapNodeComposite.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
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
}
