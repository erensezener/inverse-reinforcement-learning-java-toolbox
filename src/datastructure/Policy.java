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
	
}
