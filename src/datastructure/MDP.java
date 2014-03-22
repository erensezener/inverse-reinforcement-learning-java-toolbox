package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MDP {
	private State[][] states;
	private int featureLength;
	private HashMap<State, Set<Action>> stateToActionsMap;
	private HashMap<State, Reward> stateToRewardMap;

	public MDP(State[][] states, int featureLength) {
		this.states = states;
		stateToActionsMap = new HashMap<State, Set<Action>>();
		stateToRewardMap = new HashMap<State, Reward>();
		this.featureLength = featureLength;
		this.setAllActions();
		this.setRewardsOfAllStates();
	}
	
	public MDP(int featureLength) {
		stateToActionsMap = new HashMap<State, Set<Action>>();
		stateToRewardMap = new HashMap<State, Reward>();
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
		Set<Action> actions = new HashSet<Action>();
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
	
	//TODO add a reward logic here
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
