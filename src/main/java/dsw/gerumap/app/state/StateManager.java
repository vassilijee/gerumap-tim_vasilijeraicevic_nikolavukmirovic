package dsw.gerumap.app.state;

import dsw.gerumap.app.state.concrete.*;

public class StateManager {
    private State currState;
    private AddLinkState addLinkState;
    private AddTopicState addTopicState;
    private DeleteState deleteState;
    private MoveState moveState;
    private SelectState selectState;

    public StateManager() {
        initState();
    }

    private void initState(){
        addLinkState = new AddLinkState();
        addTopicState = new AddTopicState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        currState = selectState;
    }
}