package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
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
                MainFrame.getInstance().getProjectView().setProject((Project)selected.getMapNode());
                MainFrame.getInstance().getProjectView().getProjectName().setText(selected + " Autor: " + ((Project) selected.getMapNode()).getAuthor());
                List<Object> children = selected.getChildren();
                //System.out.println(children.size());
                for (int i = 0; i < selected.getChildCount(); i++) {
                    MindMapView tab = new MindMapView();
                    tab.setTitle(selected.getChildAt(i).toString());
                    MainFrame.getInstance().getProjectView().getTabbedPane().addTab(tab.getTitle(), tab);
                    tab.add(new JLabel(tab.getTitle()));
                    MapTreeItem item = (MapTreeItem) children.get(i);
                    //item.getMapNode().removeSubscriber(tab);
                    //tab.setMindMap((MindMap) item.getMapNode());
                    item.getMapNode().addSubscriber(tab);
                }
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
