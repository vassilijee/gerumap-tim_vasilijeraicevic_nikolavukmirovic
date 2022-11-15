package dsw.gerumap.app.gui.swing;


import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.message.Message;

import javax.swing.*;


public class SwingGui implements Gui {
    private MainFrame instance;
    private MapTree a;

    public SwingGui() {
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }

    @Override
    public void update(Object object, Object notification) {
        if(notification.equals("ERROR")){
            JOptionPane optionPane = new JOptionPane(((Message)object).getText(), JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = optionPane.createDialog("ERROR");
            dialog.setVisible(true);
            dialog.dispose();
        }
    }
}
