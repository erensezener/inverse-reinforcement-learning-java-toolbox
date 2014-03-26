package datastructure;

public class DeterministicAction extends Action {

    public DeterministicAction(State currentState, State nextState) {
        super.currentState = currentState;
        super.nextState = nextState;
    }

    @Override
    public State getNextState() {
        return super.nextState;
    }
}
