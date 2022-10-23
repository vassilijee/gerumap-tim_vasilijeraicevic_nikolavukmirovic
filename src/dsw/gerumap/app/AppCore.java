package dsw.gerumap.app;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;

public class AppCore extends ApplicationFramework {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        // mf.getContentPane().setBackground(new Color(93, 109, 126));
        mf.setVisible(true);
    }

    @Override
    public void run() {

    }
}
