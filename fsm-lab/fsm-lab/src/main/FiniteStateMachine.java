package main;

/**
 * @author Jamie Stevenson
 *
 * This class represents a simple finite state machine in the style of a cell from Conway's game of
 * life.
 */

public class FiniteStateMachine implements FSM {
	private boolean state;

	// Default Constructor
	public FiniteStateMachine () {
		state = false;
	}
	
	/* (non-Javadoc)
	 * @see main.FSM#tick()
	 */
	@Override
	public boolean tick () {
		state = !state;
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see main.FSM#state()
	 */
	@Override
	public String state () {
		return state ? "ON" : "OFF";
	}
	
}
