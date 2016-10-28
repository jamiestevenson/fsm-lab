package main;

/**
 * @author Jamie Stevenson
 *
 * This class represents a simple finite state machine in the style of a cell from Conway's game of
 * life.
 */

public class FiniteStateMachine {
	private boolean state;

	// Default Constructor
	public FiniteStateMachine () {
		state = false;
	}
	
	/**
	 * Processes a time tick for this FSM
	 * @return true if tick was carried out with no problems,
	 * 				otherwise false
	 */
	public boolean tick () {
		state = !state;
		return true;
	}
	
	
	public String state () {
		return state ? "ON" : "OFF";
	}
	
}
