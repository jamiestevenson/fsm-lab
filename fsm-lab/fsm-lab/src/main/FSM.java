package main;

public interface FSM {

	/**
	 * Processes a time tick for this FSM
	 * @return true if tick was carried out with no problems,
	 * 				otherwise false
	 */
	public abstract boolean tick();

	public abstract String state();

}