package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.Element;
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
            MainFrame.getInstance().getMapTree().expandPath();
            if (selected.getMapNode() instanceof Project) {
                MainFrame.getInstance().getProjectView().getTabbedPane().removeAll();
                selected.getMapNode().removeSubscriber(MainFrame.getInstance().getProjectView());
                selected.getMapNode().addSubscriber(MainFrame.getInstance().getProjectView());
                MainFrame.getInstance().getProjectView().getProjectName().setText(selected + " Autor: " + ((Project) selected.getMapNode()).getAuthor());
                List<Object> children = selected.getChildren();
                System.out.println(children.size());
                for (int i = 0; i < selected.getChildCount(); i++) {
                    MindMapView tab = new MindMapView();
                    tab.setTitle(selected.getChildAt(i).toString());
                    MainFrame.getInstance().getProjectView().getTabbedPane().addTab(tab.getTitle(), tab);
                    tab.add(new JLabel(tab.getTitle()));
                    MapTreeItem item = (MapTreeItem) children.get(i);
                    item.getMapNode().removeSubscriber(tab);
                    item.getMapNode().addSubscriber(tab);
                }
            }
//            } else if (selected.getMapNode() instanceof MindMap) {
//                return;
////                for (int i = 0; i < selected.getChildCount(); i++) {
////                    JPanel tab = new JPanel();
////                    String title = selected.getChildAt(i).toString();
////                    MainFrame.getInstance().getProjectView().getTabbedPane().addTab(title, tab);
////                    tab.add(new JLabel(title));
////                }
            System.out.println("size: " + selected.getChildCount());
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
