package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.controller.ExitAction;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private ActionManager actionManager;

    private JMenuBar menu;

    private JToolBar toolBar;
    private MainFrame() {

    }
    private void initialise(){
        actionManager = new ActionManager();
        initialiseGUI();
    }

    private void initialiseGUI(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2, screenHeight/2);
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
        split.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    public ActionManager getActionManager(){
        return actionManager;
    }
}
