package datastructure;

import java.util.TreeMap;

/**
 * Maps each state to a utility
 * 
 */
public class Utility {
	private TreeMap<State, Double> stateToUtilityMap;

	
	
	public Utility() {
		super();
		this.stateToUtilityMap = new TreeMap<State, Double>();
	}

	public void setUtilityOfAState(State state, Double utility) {
		if (stateToUtilityMap.containsKey(state)) {
			System.out.println("Error! This state already has an action");
		} else {
			stateToUtilityMap.put(state, utility);
		}
	}

	public Double getUtilityGivenAState(State state) {
		return stateToUtilityMap.get(state);
	}
}
