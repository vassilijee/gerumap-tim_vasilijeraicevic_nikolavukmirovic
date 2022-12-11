package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.implementation.MindMap;
import dsw.gerumap.app.repository.implementation.Subject;
import dsw.gerumap.app.state.State;

public class AddTopicState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMap m) {
        super.clickedMouse(x, y, m);
        Subject s = new Subject("Subject", m, x, y);
        m.addChild(s);
    }
}
