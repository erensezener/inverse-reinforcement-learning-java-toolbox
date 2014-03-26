package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MDP {
    private States states;
    private int featureLength;
    private HashMap<State, Set<Action>> stateToActionsMap;
    private HashMap<State, Reward> stateToRewardMap;

    public MDP(States states, int featureLength) {
        this.states = states;
        this.stateToActionsMap = new HashMap<State, Set<Action>>();
        this.stateToRewardMap = new HashMap<State, Reward>();
        this.featureLength = featureLength;
        this.setAllActions();
        this.setRewardsOfAllStates();
    }

    public MDP(int featureLength) {
        stateToActionsMap = new HashMap<State, Set<Action>>();
        stateToRewardMap = new HashMap<State, Reward>();
        this.featureLength = featureLength;
    }

    public void setStateAsTerminal(State state){
        state.setStateAsTerminal();
        stateToActionsMap.remove(state);
        stateToActionsMap.put(state, null);
    }

    public void setAllActions() {
        while(states.hasNext()){
            setAllActionsOfAState(states.next());
        }
        states.resetIterator();
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
        while(states.hasNext()){
            setRewardOfState(states.next());
        }
    }

    //TODO add a reward logic here
    private void setRewardOfState(State state) {
        state.setFeatures(new Reward(featureLength));
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public int getFeatureLength() {
        return featureLength;
    }

    public Double getTransitionProbability(State state, State neighbor, Action action) {
        return 1.0; //TODO Change this for stochastic environment
    }

}
