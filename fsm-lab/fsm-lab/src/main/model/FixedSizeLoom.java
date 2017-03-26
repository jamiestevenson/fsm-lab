package main.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

/**
 * @author Jamie Stevenson
 * 
 * This class provides wrapper facilities for a simulation comprising one or more
 * Finite State Machines.  This includes adding and removing FSMs, managing neighbourhood and
 * applying time progression.
 */

public class FixedSizeLoom implements Loom {
	
	private final static int MIN_DIMENSION = 2;
	
	private int width;
	private int depth;
	private int fsmCount;
	// Addressed [width][depth], (x,y) from top left
	private FSM[][] machines;
	
	public FixedSizeLoom () {
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
	public FixedSizeLoom (int width, int depth) {
		this.width = validDimension(width);
		this.depth = validDimension(depth);
		this.fsmCount = 0;
		machines = new FSM[this.width][this.depth];
	}

	@Override
	public Dimension dimension () {
		return new Dimension(width, depth);
	}
	
	@Override
	public boolean add (FSM fsm) {
		if(fsm == null || isFull()){
			return false;
		}
		return addToFirstAvailableCell(fsm);
	}
	
	@Override
	public boolean put (FSM fsm, int x, int y) {
		machines[x][y] = fsm;
		fsmCount++;
		return true;
	}
	
	@Override
	public FSM getCellContents (int x, int y) {
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
	
	
	private boolean addToFirstAvailableCell(FSM fsm) {
		
		int x = 0;
		int y = 0; // change to point
		int capacity = width*depth;
		
		for (int i = 1; i <= capacity;i++) {
			if (getCellContents(x, y) == null) {
				return put(fsm, x, y);
			} else {
				Point p = advancePointer(x, y);
				x = (int) p.getX();
				y = (int) p.getY();
				assert(isOnGrid(x, y));
			}
		}
		return false;
	}

	
	// Naive diagonal traversal
	private Point advancePointer(int x, int y) {
		
		if (inFirstRowOrLastColumn(x,y)) {
			return wrapPointer(machines ,x, y);
		} else {
			return moveUpAndLeft(x, y);
		}
	}

	private boolean inFirstRowOrLastColumn(int x, int y) {
		return x == 0 || y == width-1;
	}

	private Point moveUpAndLeft (int x, int y) {
		return new Point(x-1, y+1);
		
	}

	public static Point wrapPointer (FSM[][] grid, int x, int y) {
		int maxY = grid[0].length-1;
		int maxX = grid.length-1;
		if (x == maxX && y == maxY) { // bottom left corner
			return new Point(0,0);
		} else if(x == 0 && y == maxY) { // top right corner
			return new Point(maxX, 1);
		} else if (x == 0) {                // other top row
			return new Point(y+1, 0);
		} else if (y == maxY) {                // last column
			return new Point(x+1, maxX);
		} else {                            // internal move
			return new Point(x-1, y+1);
		}
	}

	private boolean isOnGrid (int x, int y) {
		return x>=0 && x<width && y>=0 && y<depth;
	}

	@Override
	public boolean tick() {
		Arrays.stream(machines).
			flatMap(s -> Arrays.stream(s)).
			filter(f -> null!=f).
			forEach(f -> System.out.println(f.state()));
		return false;
	}
	
}
