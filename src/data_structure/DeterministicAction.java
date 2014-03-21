package data_structure;

public class DeterministicAction extends Action {
	
	public DeterministicAction(State currentState, State nextState) {
		super();
		super.currentState = currentState;
		super.nextState = nextState;
	}

	@Override
	public State getNextState() {
		 return super.nextState;
	}
}
