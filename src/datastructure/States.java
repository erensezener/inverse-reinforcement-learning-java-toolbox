package datastructure;

import java.util.Iterator;

public class States implements Iterator<State> {
	private State[][] states; //TODO states might be represented with other data structures 
	private int numberOfRows;
	private int numberOfColumns;
	private int iteratorIndex;
	
	public States(State[][] states) {
		this.numberOfRows = states.length;
		this.numberOfColumns = states[0].length;
		this.states = states;
		this.iteratorIndex = 0;
	}

	@Override
	public boolean hasNext() {
		return iteratorIndex < (states.length * states[0].length - 1);
	}

	@Override
	public State next() {
		return states[iteratorIndex/numberOfRows][iteratorIndex % numberOfColumns]; //TODO Check this
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
