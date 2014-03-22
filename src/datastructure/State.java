/**
 * 
 */
package datastructure;

import java.util.ArrayList;

/**
 * @author erensezener
 * 
 */
public class State {
	private int id;
	private boolean isFinalState;
	private ArrayList<State> neighborStates;
	private double[] features;
	
	public State(int id, int featureLength) {
		super();
		this.id = id;
		this.isFinalState = false;
		this.neighborStates = new ArrayList<State>();
		this.features = new double[featureLength];
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
