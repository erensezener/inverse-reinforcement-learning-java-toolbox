/**
 * 
 */
package datastructure;

import java.util.HashMap;

/**
 * A Policy instance is basically a state -> action map
 * 
 * @author erensezener
 * 
 *
 */
public class Policy {
    private HashMap<State, Action> stateToActionMap;

    public Policy(){
        stateToActionMap = new HashMap<State, Action>();
    }

    public int getNumberfOfMappings(){
		return stateToActionMap.size();
	}
	
	public void setActionOfAState(State state, Action actionToSet){
		if(stateToActionMap.containsKey(state)){
			System.out.println("Error! This state already has an action");
		} else{
			stateToActionMap.put(state, actionToSet);
		}	
	}
	
	public Action getActionGivenAState(State state){
		return stateToActionMap.get(state);
	}
}
