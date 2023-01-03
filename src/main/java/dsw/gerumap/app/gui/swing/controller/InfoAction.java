package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGerumapAction {
    public InfoAction() {
        // putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4,
        // InputEvent.ALT_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("/images/info.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label1 = new JLabel("<html>Vasilije Raicevic RN 90/22<br>Nikola Vukmirovic RN 41/21</html>");
        ImageIcon slika = (ImageIcon) loadIcon("/images/nikola_vasa.jpeg");
        Image novaSlika = slika.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(novaSlika);
        JLabel label2 = new JLabel(icon);
        JLabel[] arr = {label2, label1};
        JOptionPane pane = new JOptionPane(arr);
        JDialog dialog = pane.createDialog("Info");
        dialog.setVisible(true);
        dialog.dispose();
    }
}
