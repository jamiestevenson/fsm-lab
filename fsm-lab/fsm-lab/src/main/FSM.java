package main;

/**
 * @author Jamie Stevenson
 *
 * This interface represents the requirements for a Finite State Machine definition to 'hook in' to
 * the rest of the simulation.
 * 
 * Note that STATE is expressed as string as this provides an open ended means of communication
 * protocol for FSMs, without the need to define many enums etc.  This may lead to namespace issues
 * if large numbers of FSMs are designed without due care - solving this problem might be an
 * interesting assignment. 
 */

public interface FSM {

	/**
	 * Processes a time tick for this FSM
	 * @return true if tick was carried out with no problems,
	 * 				otherwise false
	 */
	public abstract boolean tick();

	/**
	 * Gets a representation of the current state of this FSM, note that the FSM is under no
	 * requirement to 'tell the truth' or reveal too much information, this is the public face of 
	 * the FSM available to it's environment.
	 * @return String - some message indicating state.
	 */
	public abstract String state();

}