package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.repository.command.AbstractCommand;
import dsw.gerumap.app.repository.command.implementation.AddTopicCommand;
import dsw.gerumap.app.repository.implementation.Topic;
import dsw.gerumap.app.state.State;

public class AddTopicState extends State {
    static int count = 0;

    @Override
    public void clickedMouse(int x, int y, MindMapView mindMapView) {
        Topic topic = new Topic("Topic" + count, mindMapView.getMindMap(), x, y);
        count++;
        AbstractCommand abstractCommand = new AddTopicCommand(topic, mindMapView.getMindMap());
        mindMapView.getMindMap().getCommandManager().addCommand(abstractCommand);
    }
}