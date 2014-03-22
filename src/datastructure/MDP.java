package datastructure;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MDP {
	private State[][] states;
	private int featureLength;
	private TreeMap<State, Set<Action>> stateToActionsMap;
	private TreeMap<State, Reward> stateToRewardMap;

	public MDP(int featureLength) {
		stateToActionsMap = new TreeMap<State, Set<Action>>();
		stateToRewardMap = new TreeMap<State, Reward>();
		this.featureLength = featureLength;
	}

	public void setAllActions() {
		for (State[] stateRow : states) {
			for (State state : stateRow) {
				setAllActionsOfAState(state);
			}
		}
	}

	/*
	 * Sets the available actions for a given state.
	 */
	private void setAllActionsOfAState(State state) {
		Set<Action> actions = new TreeSet<Action>();
		for (State neighbor : state.getNeighborStates()) {
			actions.add(new DeterministicAction(state, neighbor));
		}
		stateToActionsMap.put(state, actions);
	}
	
	public void setRewardsOfAllStates(){
		for (State[] stateRow : states) {
			for (State state : stateRow) {
				setRewardOfState(state);
			}
		}		
	}
	
	private void setRewardOfState(State state) {
		state.setFeatures(new Reward(featureLength));
	}

	public State[][] getStates() {
		return states;
	}

	public void setStates(State[][] states) {
		this.states = states;
	}
}
