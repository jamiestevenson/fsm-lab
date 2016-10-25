package main;

/**
 * @author Jamie Stevenson
 *
 * This class represents a simple finite state machine in the style of a cell from Conway's game of
 * life.
 */

public class FiniteStateMachine {
	private String state;

	// Default Constructor
	public FiniteStateMachine () {
		state = "flip";
	}
	
	/**
	 * Processes a time tick for this FSM
	 * @return true if tick was carried out with no problems,
	 * 				otherwise false
	 */
	public boolean tick () {
		if (state.equals("flip")) {
			state = "flop";
		} else {
			state = "flip";
		}
		return true;
	}
	
	
	public String state () {
		return state;
	}
	
}
