package algorithm;

import datastructure.*;

public class PolicyEvaluation {
	private int numberOfIterations;
	private double gamma; // should be between 0 and 1
	private Policy policy;
	private MDP mdp;

	public PolicyEvaluation(int numberOfIterations, double gamma, MDP mdp,
			Policy policy) {
		if (gamma > 1.0 || gamma <= 0.0) {
			throw new IllegalArgumentException("Gamma must be > 0 and <= 1.0");
		}
		this.numberOfIterations = numberOfIterations;
		this.gamma = gamma;
		this.policy = policy;
		this.mdp = mdp;
	}

	public Utility evaluate() {
		Utility utility = new Utility();
		for (int iteration = 0; iteration < numberOfIterations; iteration++) {

		}
		return utility;
	}
}
