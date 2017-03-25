package main;

/**
 * @author Jamie Stevenson
 *
 * This class represents a simple finite state machine in the style of a cell from Conway's game of
 * life.
 */

public class FiniteStateMachine implements FSM {
	private boolean state;

	public FiniteStateMachine () {
		state = false;
	}
	
	@Override
	public boolean tick () {
		state = !state;
		return true;
	}
	
	@Override
	public String state () {
		return state ? "ALIVE" : "DEAD";
	}
	
}
