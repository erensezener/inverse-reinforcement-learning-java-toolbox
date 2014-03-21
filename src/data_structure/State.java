/**
 * 
 */
package data_structure;

import java.util.ArrayList;

/**
 * @author erensezener
 * 
 */
public class State {
	private int id;
	private boolean isFinalState;
	private ArrayList<State> neighborStates;
	private ArrayList<Action> actions;
	private double[] features;
	
	public State(int id) {
		super();
		this.id = id;
		this.isFinalState = false;
		this.neighborStates = new ArrayList<State>();
		this.actions = new ArrayList<Action>();
		this.features = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFinalState() {
		return isFinalState;
	}

	public void setFinalState(boolean isFinalState) {
		this.isFinalState = isFinalState;
	}

	public ArrayList<State> getNeighborStates() {
		return neighborStates;
	}

	public void setNeighborStates(ArrayList<State> neighborStates) {
		this.neighborStates = neighborStates;
	}

	public void addNeighborState(State neighborState) {
		this.neighborStates.add(neighborState);
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	/*
	 * Use this if all neighbors are set
	 */
	public void setAllActions() {
		for (State neighbor : neighborStates) {
			actions.add(new DeterministicAction(this, neighbor));
		}
	}

	public double[] getFeatures() {
		return features;
	}

	public void setFeatures(double[] features) {
		this.features = features;
	}

	@Override
	public String toString() {
	// String is composed of ID and Neighbor ID's
		StringBuffer buffer = new StringBuffer();
		buffer.append("ID: " + String.valueOf(id) +"\n");
		buffer.append("Neighbors: ");
		for (State neighbor : neighborStates)
			buffer.append(String.valueOf(neighbor.getId()) + " ");
		return buffer.toString();
	}

}
