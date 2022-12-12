package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;

public class AddTopicState extends State {
    static int count = 0;

    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        Topic t = new Topic("Topic" + count, m.getMindMap(), x, y);
        count++;
        m.getMindMap().addChild(t);
    }
}
