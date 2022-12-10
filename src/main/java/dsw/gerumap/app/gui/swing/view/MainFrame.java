package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private MapTree mapTree;
    private static MainFrame instance;
    private ProjectView projectView;
    private JTree projectExplorer;
    private JToolBar vToolbar;

    private MainFrame() {

    }

    private void initialise() {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        // MessageGeneratorImplementation.getInstance().addSubscriber(new
        // ConsoleLogger());
        // MessageGenerator.getInstance().addSubscriber(new FileLogger());
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
        projectExplorer = mapTree
                .generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());
        projectView = new ProjectView();
        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, projectView);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
        vToolbar = new VToolbar();
        add(vToolbar, BorderLayout.EAST);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    @Override
    public void update(Object publisher, Object notification) {
        if (notification.equals("DELETE")) {
            if (publisher instanceof Project)
                System.out.println("NE RADI");
        }
    }
}
