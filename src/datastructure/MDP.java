package datastructure;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MDP {
	private State[][] states; 
	private TreeMap<State, Set<Action>> stateToActionsMap;
	private TreeMap<State, Reward> stateToRewardMap;
	
	
	
	public void setAllActions(){
		for(State[] stateRow : states){
			for(State state : stateRow){
				setAllActionsOfAState(state);
			}
		}
	}
	
	/*
	 * Sets the available actions for a given state.
	 */
	public void setAllActionsOfAState(State state) {
		Set<Action> actions = new TreeSet<Action>();
		for (State neighbor : state.getNeighborStates()) {
			actions.add(new DeterministicAction(state, neighbor));
		}
		stateToActionsMap.put(state, actions);
	}
	
}
