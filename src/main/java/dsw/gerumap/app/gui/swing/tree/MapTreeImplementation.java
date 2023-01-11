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
import dsw.gerumap.app.repository.implementation.*;

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
        for (MapNode mapNode:
             node.getChildren()) {
            MapTreeItem loadedMap = new MapTreeItem(mapNode);
            mapNode.setParent(node);
            MapNodeComposite mapNodeComposite1 = (MapNodeComposite) mapNode;
            for (MapNode mapNode1:
                 mapNodeComposite1.getChildren()) {
                mapNode1.setParent(mapNode);
                if(mapNode1 instanceof Link){
                    for (MapNode mapNode2:
                         mapNodeComposite1.getChildren()) {
                        if(mapNode2 instanceof Topic){
                            if(mapNode2.getName().equals(((Link) mapNode1).getTopicFrom().getName())){
                                ((Link) mapNode1).setTopicFrom((Topic) mapNode2);
                            }else if(mapNode2.getName().equals(((Link) mapNode1).getTopicTo().getName())){
                                ((Link) mapNode1).setTopicTo((Topic) mapNode2);
                            }
                        }
                    }
                }
            }
            loadedProject.add(loadedMap);
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void loadMindMap(MindMap node) {
        MapTreeItem loadedMindMap = new MapTreeItem(node);
        MainFrame.getInstance().getMapTree().getSelectedNode().add(loadedMindMap);
        Project mapNodeComposite = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        mapNodeComposite.addChild(node);
        for (MapNode mapNode:
             node.getChildren()) {
            mapNode.setParent(node);
            if(mapNode instanceof Link){
                for (MapNode mapNode1:
                     node.getChildren()) {
                    if(mapNode1 instanceof Topic){
                        if(mapNode1.getName().equals(((Link) mapNode).getTopicFrom().getName())){
                            ((Link) mapNode).setTopicFrom((Topic) mapNode1);
                        }else if(mapNode1.getName().equals(((Link) mapNode).getTopicTo().getName())){
                            ((Link) mapNode).setTopicTo((Topic) mapNode1);
                        }
                    }
                }
            }
        }
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
