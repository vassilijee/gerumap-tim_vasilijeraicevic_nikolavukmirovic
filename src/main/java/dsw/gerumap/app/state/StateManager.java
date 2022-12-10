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

    public State getCurrent(){
        return currState;
    }

    public void setAddLinkState(AddLinkState addLinkState) {
        currState = addLinkState;
    }

    public void setAddTopicState(AddTopicState addTopicState) {
        currState = addTopicState;
    }

    public void setDeleteState(DeleteState deleteState) {
        currState = deleteState;
    }

    public void setMoveState(MoveState moveState) {
        currState = moveState;
    }

    public void setSelectState(SelectState selectState) {
        currState = selectState;
    }
}