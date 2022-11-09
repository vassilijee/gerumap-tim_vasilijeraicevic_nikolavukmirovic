package dsw.gerumap.app.gui.swing.controller;

import com.sun.tools.javac.Main;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TabAction extends AbstractGerumapAction implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
            if (selected == null)
                return;
            else {
                MainFrame.getInstance().getMapTree().expandPath();
                MainFrame.getInstance().getProjectView().getTabbedPane().removeAll();
                if (selected.getMapNode() instanceof Project) {
                    MainFrame.getInstance().getProjectView().getProjectName().setText(selected + " Autor: " + selected.getAuthor());
                }
                for (int i = 0; i < selected.getChildCount(); i++) {
                    JPanel temp = new JPanel();
                    String titleOfMap = selected.getChildAt(i).toString();
                    System.out.printf(selected.getChildAt(i).toString() + "\n");
                    MainFrame.getInstance().getProjectView().getTabbedPane().addTab(titleOfMap, temp);
                    temp.add(new JLabel(titleOfMap));
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
