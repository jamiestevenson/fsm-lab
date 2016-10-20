package main;

import java.awt.Dimension;
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
	private List<FiniteStateMachine> machines;
	
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
		machines = new ArrayList<>();
	}

	
	/**
	 * Gets the dimensions of the Loom, note that this is an indication of capacity, not the number
	 * FSMs present in the Loom. 
	 * @return Dimension indicating the size of this Loom
	 */
	public Dimension dimension () {
		return new Dimension(width, depth);
	}
	
	
	public boolean put(FiniteStateMachine fsm) {
		if(fsm == null || machines.size() == (width*depth)){
			return false;
		} else {
			return machines.add(fsm);
		}
	}
	
	
	private int validDimension(int d) {
		return d < MIN_DIMENSION ? MIN_DIMENSION : d;
	}
	
}
