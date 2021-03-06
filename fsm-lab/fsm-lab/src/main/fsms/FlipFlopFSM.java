package main.fsms;

import main.model.FSM;

/**
 * @author Jamie Stevenson
 *
 * This class represents a simple finite state machine in the style of a cell from Conway's game of
 * life.
 */

public class FlipFlopFSM implements FSM {
	private boolean state;

	public FlipFlopFSM () {
		state = false;
	}
	
	@Override
	public boolean tick () {
		state = !state;
		return true;
	}
	
	@Override
	public String state () {
		return state ? "ON" : "OFF";
	}
	
}
