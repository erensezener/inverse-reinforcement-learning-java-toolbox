/**
 * 
 */
package datastructure;

import java.util.TreeMap;

/**
 * @author erensezener
 *
 */
public class Policy {
	private TreeMap<State, Action> stateToActionMap;
	
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
