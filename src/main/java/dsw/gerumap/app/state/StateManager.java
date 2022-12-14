package dsw.gerumap.app.state;

import dsw.gerumap.app.state.concrete.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateManager {
    private State currState;
    private AddLinkState addLinkState;
    private AddTopicState addTopicState;
    private DeleteState deleteState;
    private MoveState moveState;
    private SelectState selectState;
    private ZoomState zoomState;

    public StateManager() {
        initState();
    }

    private void initState() {
        addLinkState = new AddLinkState();
        addTopicState = new AddTopicState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        currState = addTopicState;
    }

    public State getCurrent() {
        return currState;
    }

    public void setAddLinkState() {
        currState = addLinkState;
    }

    public void setAddTopicState() {
        currState = addTopicState;
    }

    public void setDeleteState() {
        currState = deleteState;
    }
    public void setZoomState(){
        currState = zoomState;
    }

    public void setMoveState() {
        currState = moveState;
    }

    public void setSelectState() {
        currState = selectState;
    }
}