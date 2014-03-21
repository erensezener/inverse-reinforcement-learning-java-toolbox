package main_methods;

import data_structure.State;

public class Test {

	public static void main(String[] args) {
		State[][] states = new State[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				states[i][j] = new State((i) * 4 + j);
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

	}

	private static void setNextStateOf(State state1, State state2) {
		state1.addNeighborState(state2);
		state2.addNeighborState(state1);
	}
}
