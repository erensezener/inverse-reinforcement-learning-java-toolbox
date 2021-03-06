package datastructure;

public abstract class Action {
    protected State currentState;
    protected State nextState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public abstract State getNextState();

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
