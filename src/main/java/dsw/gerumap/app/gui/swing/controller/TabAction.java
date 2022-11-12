package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TabAction extends AbstractGerumapAction implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
            if (selected.getMapNode() instanceof Project) {
                selected.getMapNode().addSubscriber(MainFrame.getInstance().getProjectView());
            }
            if (selected == null)
                return;
            else {
                MainFrame.getInstance().getMapTree().expandPath();
                MainFrame.getInstance().getProjectView().getTabbedPane().removeAll();
                if (selected.getMapNode() instanceof Project) {
                    MainFrame.getInstance().getProjectView().getProjectName().setText(selected + " Autor: " + ((Project) selected.getMapNode()).getAuthor());
                }
                for (int i = 0; i < selected.getChildCount(); i++) {
                    MindMapView temp = new MindMapView();
                    String titleOfMap = selected.getChildAt(i).toString();
                    System.out.println(selected.getChildAt(i).toString() + "\n");
                    MainFrame.getInstance().getProjectView().getTabbedPane().addTab(titleOfMap, temp);
                    temp.add(new JLabel(titleOfMap));
                    // TREBA DA DODAJE SVAKI NOVI TAB NA SUBSCRIBERE
                    if(selected.getMapNode() instanceof Project){
                        MapNode mapNode = selected.getMapNode();
                        MapNodeComposite mapNodeComposite = (MapNodeComposite) mapNode;
                        List<MapNode> mapNodes = mapNodeComposite.getChildren();
                        System.out.println(mapNodes.size());
//                        MindMap mindMap = (MindMap) mapNodes.get(i);
//                        mindMap.addSubscriber(temp);
                    }
                }
                System.out.println("size: " + selected.getChildCount());
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
