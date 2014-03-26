package mainmethods;

import algorithm.*;
import datastructure.*;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    public Test() {
    }

    public static void main(String[] args) {
        int featureLength = 1;
        State[][] states = new State[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                states[i][j] = new State((i) * 4 + j, featureLength);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < 4 && j < 3)
                    setNextStateOf(states[i][j], states[i][j + 1]);
                if (i < 3 && j < 4)
                    setNextStateOf(states[i][j], states[i + 1][j]);

            }
        }

        // System.out.println();
        // System.out.println(states[0][0].toString());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(states[i][j].toString());
            }
        }

        States statesObject = new States(states);

        MDP mdp = new MDP(statesObject, featureLength);
        Policy policy = new Policy();
        Random rand = new Random();

        while (statesObject.hasNext()) {
            State state = statesObject.next();
            ArrayList<State> neighborsOfState = state.getNeighborStates();
            int actionIndex = rand.nextInt(neighborsOfState.size());

            policy.setActionOfAState(state, new DeterministicAction(state, neighborsOfState.get(actionIndex)));
        }
        statesObject.resetIterator();

        System.out.println();

        PolicyEvaluation evaluation = new PolicyEvaluation(100, 0.9, mdp, policy);

        Utility finalUtil = evaluation.evaluate();

        System.out.println(finalUtil.getUtilityGivenAState(statesObject.next()));
    }

    private static void setNextStateOf(State state1, State state2) {
        state1.addNeighborState(state2);
        state2.addNeighborState(state1);
    }
}