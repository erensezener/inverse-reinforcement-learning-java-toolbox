package datastructure;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Maps each state to a utility
 *
 */
public class Utility {
    private HashMap<State, Double> stateToUtilityMap;

    public Utility() {
        super();
        this.stateToUtilityMap = new HashMap<State, Double>();
    }

    public void setUtilityOfAState(State state, Double utility) {
        if (stateToUtilityMap.containsKey(state)) { //Update the utility
            stateToUtilityMap.remove(state);
            stateToUtilityMap.put(state, utility);
        } else {
            stateToUtilityMap.put(state, utility);
        }
    }

    public Double getUtilityGivenAState(State state) {
        if (stateToUtilityMap.get(state) != null)
            return stateToUtilityMap.get(state);
        else
            return new Double(0);
    }
}
