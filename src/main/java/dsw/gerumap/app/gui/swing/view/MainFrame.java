package dsw.gerumap.app.gui.swing.view;


import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private JTabbedPane tab;
    private MapTree mapTree;
    private static MainFrame instance;

    private MainFrame() {

    }

    private void initialise() {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGUI();
    }

    private void initialiseGUI() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        JPanel desktop = new JPanel();
        JScrollPane scroll = new JScrollPane();
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
//        split.setOneTouchExpandable(true);

        TabbedPane tabbedPane = new TabbedPane();
        JPanel test1 = new JPanel();
        test1.add(new JLabel("test1"));
        JPanel test2 = new JPanel();
        test2.add(new JLabel("test2"));
        JPanel test3 = new JPanel();
        test3.add(new JLabel("test3"));

        tabbedPane.addTab("test1", test1);
        tabbedPane.addTab("test2", test2);
        tabbedPane.addTab("test3", test3);

        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
