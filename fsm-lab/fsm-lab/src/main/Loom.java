package main;

import java.awt.Dimension;
import java.awt.Point;

/**
 * @author Jamie Stevenson
 * 
 * This class provides wrapper facilities for a simulation comprising one or more
 * Finite State Machines.  This includes adding and removing FSMs, managing neighborhood and
 * applying time progression.
 */

public class Loom {
	
	private final static int MIN_DIMENSION = 2;
	
	private int width;
	private int depth;
	private int fsmCount;
	// Addressed [width][depth], (x,y) from top left
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
		machines = new FiniteStateMachine[this.width][this.depth];
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
		machines[x][y] = fsm;
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
		return machines[x][y];
	}
	
	
	/**
	 * Returns a valid Dimension that can be the size of this Loom
	 * @param d - candidate dimension
	 * @return Dimension that is based in the input Dimension d, adjusted to meet minimum
	 * size for this Loom object.
	 */
	private int validDimension (int d) {
		if (d > MIN_DIMENSION) {
			return d;
		}
		return MIN_DIMENSION;
	}
	
	
	private boolean isFull () {
		return fsmCount == (width*depth);
	}
	
	
	private boolean addToFirstAvailableCell(FiniteStateMachine fsm) {
		
		int x = 0;
		int y = 0; // change to point
		int capacity = width*depth;
		
		for (int i = 1; i <= capacity;i++) {
			if (getCellContents(x, y) == null) {
				System.out.println("Added fsm to ("+x+","+y+")");
				return put(fsm, x, y);
			} else {
				Point p = advancePointer(x, y);
				x = (int) p.getX();
				y = (int) p.getY();
			}
		}
		return false;
	}

	
	// Naive diagonal traversal
	private Point advancePointer(int x, int y) {
		
		if (inFirstRowOrLastColumn(x,y)) {
			return wrapPointer(x, y);
		} else {
			return moveUpAndLeft(x, y);
		}
	}

	private boolean inFirstRowOrLastColumn(int x, int y) {
		return x == 0 || y == width-1;
	}

	private Point moveUpAndLeft (int x, int y) {
		return new Point(x+1, y-1);
		
	}

	private Point wrapPointer(int x, int y) {
		if(x == 0 && y == width-1) { // top left corner
			return new Point(x+1, depth-1);
		} else if (x == 0) { //other top row
			return new Point(y+1, 0);
		} else { // last column
			return new Point(x+1, depth-1);
		}
	}

	private boolean isOnGrid (int x, int y) {
		return x>=0 && x<width && y>=0 && y<depth;
	}
	
}
