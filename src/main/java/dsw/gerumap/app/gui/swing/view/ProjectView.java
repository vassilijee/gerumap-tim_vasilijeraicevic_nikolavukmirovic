package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.observer.ISubscriber;

public class ProjectView implements ISubscriber {
    @Override
    public void update(Object notification) {
        MainFrame.getInstance().getProjectName().setText("");
    }
}
