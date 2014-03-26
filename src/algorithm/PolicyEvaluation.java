package algorithm;

import datastructure.*;

import java.util.ArrayList;

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

    /*
    Based on the code of Ciaran O'Reilly and Ravi Mohan
     */
    public Utility evaluate() {
        Utility utility = new Utility();
        for (int iteration = 0; iteration < numberOfIterations; iteration++) {
            while (mdp.getStates().hasNext()) {
                State state = mdp.getStates().next();
                Action action = policy.getActionGivenAState(state);
                double actionSum = 0;
                ArrayList<State> neighborStates = state.getNeighborStates();
                for (State neighbor : neighborStates) {
                    actionSum += mdp.getTransitionProbability(state, neighbor, action) * utility.getUtilityGivenAState(neighbor);
                }
                utility.setUtilityOfAState(state, gamma * actionSum);
            }
            mdp.getStates().resetIterator();
        }
        return utility;
    }
}