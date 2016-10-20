package main;

import java.awt.Dimension;

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
	}

	public Dimension dimension () {
		return new Dimension(width, depth);
	}
	
	private int validDimension(int d) {
		return d < MIN_DIMENSION ? MIN_DIMENSION : d;
	}
	
}
