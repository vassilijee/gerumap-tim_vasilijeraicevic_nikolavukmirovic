package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.observer.IPublisher;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class MindMapView extends JPanel implements ISubscriber {
    public MindMapView(BorderLayout borderLayout) {
        setLayout(borderLayout);
    }

    @Override
    public void update(IPublisher iPublisher, Object notification) {

    }
}
