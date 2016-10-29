package main;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jamie Stevenson
 * 
 * This class provides wrapper facilities for a simulation comprising one or more
 * Finite State Machines.  This includes adding and removing FSMs, managing neighborhood and
 * applying time progression.
 */

public class Loom {
	
	private final static int MIN_DIMENSION = 1;
	
	private int width;
	private int depth;
	private int fsmCount;
	// Addressed [depth][width]
	private FiniteStateMachine[][] machines;
	
	public Loom () {
		this(MIN_DIMENSION,MIN_DIMENSION);
	}

	/**
	 * Constructor for specified-size Loom
	 * @param width - the number of FSMs accross in the container
	 * @param depth - the numner of FSMs down in the container
	 *
	 * NB - the minimum size for either dimension is one, this value will be set in the absence of
	 *      legal value.
	 */
	public Loom (int width, int depth) {
		this.width = validDimension(width);
		this.depth = validDimension(depth);
		this.fsmCount = 0;
		machines = new FiniteStateMachine[depth][width];
	}

	
	/**
	 * Gets the dimensions of the Loom, note that this is an indication of capacity, not the number
	 * FSMs present in the Loom. 
	 * @return Dimension indicating the size of this Loom
	 */
	public Dimension dimension () {
		return new Dimension(width, depth);
	}
	
	
	/**
	 * Add a FSM to this collection
	 * @param fsm - a FSM
	 * @return - true if added, otherwise false
	 * 
	 * NB - the FSM will be added on a best effort basis, near the origin (0,0) (top left), if
	 * there is no room, or the input is null, the input will not be added to this collection.
	 */
	public boolean add (FiniteStateMachine fsm) {
		if(fsm == null || isFull()){
			return false;
		}
		return addToFirstAvailableCell(fsm);
	}
	

	/**
	 * Puts a FSM in a specific location in the Loom 
	 * @param fsm - a FiniteStateMachine to add
	 * @param x - the column to add the FSM
	 * @param y - the row to add the FSM
	 * @return - true if the FSM is added, otherwise false
	 */
	public boolean put (FiniteStateMachine fsm, int x, int y) {
		machines[y][x] = fsm;
		fsmCount++;
		return true;
	}
	
	
	/**
	 * Get the FSM at the specified coordinates
	 * @param x - the column 
	 * @param y - the row
	 * @return - the FSM at the location (x,y) or null if the location is empty
	 * 
	 * NB - some FSM configurations may use some form of null object
	 */
	public FiniteStateMachine getCellContents (int x, int y) {
		return machines[y][x];
	}
	
	
	/**
	 * Returns a valid Dimension that can be the size of this Loom
	 * @param d - candidate dimension
	 * @return Dimension that is based in the input Dimension d, adjusted to meet minimum
	 * size for this Loom object.
	 */
	private int validDimension (int d) {
		return d < MIN_DIMENSION ? MIN_DIMENSION : d;
	}
	
	
	private boolean isFull () {
		return fsmCount == (width*depth);
	}
	
	
	private boolean addToFirstAvailableCell(FiniteStateMachine fsm) {
		
		int x = 0;
		int y = 0;
		int capacity = width*depth;
		
		for (int i = 1; i <= capacity;i++) {
			if (machines[y][x] == null) {
				machines[y][x] = fsm;
				return true;
			} else {
				if (x < y && x < width) {
					x++;
				} else if(y >= x && y < depth) {
					y++;
				}
			}
		}
		return false;
	}

	
}
