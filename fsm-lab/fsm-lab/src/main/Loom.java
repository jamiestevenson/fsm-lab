package main;

import java.awt.Dimension;

public interface Loom {

	/**
	 * Gets the dimensions of the Loom, note that this is an indication of capacity, not the number
	 * FSMs present in the Loom. 
	 * @return Dimension indicating the size of this Loom
	 */
	public abstract Dimension dimension();

	/**
	 * Add a FSM to this collection
	 * @param fsm - a FSM
	 * @return - true if added, otherwise false
	 * 
	 * NB - the FSM will be added on a best effort basis, near the origin (0,0) (top left), if
	 * there is no room, or the input is null, the input will not be added to this collection.
	 */
	public abstract boolean add(FSM fsm);

	/**
	 * Puts a FSM in a specific location in the Loom 
	 * @param fsm - a FiniteStateMachine to add
	 * @param x - the column to add the FSM
	 * @param y - the row to add the FSM
	 * @return - true if the FSM is added, otherwise false
	 */
	public abstract boolean put(FSM fsm, int x, int y);

	/**
	 * Get the FSM at the specified coordinates
	 * @param x - the column 
	 * @param y - the row
	 * @return - the FSM at the location (x,y) or null if the location is empty
	 * 
	 * NB - some FSM configurations may use some form of null object
	 */
	public abstract FSM getCellContents(int x, int y);

}