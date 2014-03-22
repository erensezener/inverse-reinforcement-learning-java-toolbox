package datastructure;

public class Agent {
	private Policy policy;
	private double[] weights; 
	private MDP mdp;

	public Agent(MDP mdp){
		this.mdp = mdp;
		this.weights = new double[mdp.getFeatureLength()];
	}
	
	public Agent(MDP mdp, Policy policy){
		this.mdp = mdp;
	
	}
}
