package test.model;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;

import main.model.FSM;
import main.model.FixedSizeLoom;

import org.junit.Test;

/**
 * @author Jamie Stevenson
 * 
 * This class tests behavior specific to the FixedSizeLoom implementation
 * of the Loom interface.
 */

public class FixedSizeLoomTest {

	@Test
	public void defaultConstruct_LoomTest () {
		FixedSizeLoom lm = new FixedSizeLoom();
		assertNotNull(lm);
	}
	
	@Test
	public void specificConstruct1x1_LoomTest () {
		FixedSizeLoom lm = new FixedSizeLoom(1,1);
		assertNotNull(lm);
	}
	
	@Test 
	public void defaultDimension_LoomTest () {
		FixedSizeLoom lm = new FixedSizeLoom();
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(2 == d.getHeight());
		assertTrue(2 == d.getWidth());
	}

	
	@Test 
	public void specifiedDimension_LoomTest () {
		FixedSizeLoom lm = new FixedSizeLoom(3,3);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(3 == d.getHeight());
		assertTrue(3 == d.getWidth());
	}
	
	@Test 
	public void invalidDimension_LoomTest () {
		FixedSizeLoom lm = new FixedSizeLoom(0,0);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(2 == d.getHeight());
		assertTrue(2 == d.getWidth());
	}
	
	@Test
	public void wrapPointer_NW () {
		
    /* [o][ ][ ]    [ ][ ][ ]
	   [ ][ ][ ] -> [o][ ][ ]
	   [ ][ ][ ]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 0, 0);
		assertEquals(1, destination.x);
		assertEquals(0, destination.y);
	}
	
	@Test
	public void wrapPointer_N () {
		
	    /* [ ][o][ ]    [ ][ ][ ]
		   [ ][ ][ ] -> [ ][ ][ ]
		   [ ][ ][ ]    [o][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 0, 1);
		assertEquals(2, destination.x);
		assertEquals(0, destination.y);
	}
	
	@Test
	public void wrapPointer_NE () {
		
	    /* [ ][ ][o]    [ ][ ][ ]
		   [ ][ ][ ] -> [ ][ ][ ]
		   [ ][ ][ ]    [ ][o][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 0, 2);
		assertEquals(2, destination.x);
		assertEquals(1, destination.y);
	}
	
	@Test
	public void wrapPointer_E () {
		
	    /* [ ][ ][ ]    [ ][ ][ ]
		   [ ][ ][o] -> [ ][ ][ ]
		   [ ][ ][ ]    [ ][ ][o] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 1, 2);
		assertEquals(2, destination.x);
		assertEquals(2, destination.y);
	}
	
	@Test
	public void wrapPointer_SE () {
		
	    /* [ ][ ][ ]    [o][ ][ ]
		   [ ][ ][ ] -> [ ][ ][ ]
		   [ ][ ][o]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 2, 2);
		assertEquals(0, destination.x);
		assertEquals(0, destination.y);
	}
	
	@Test
	public void wrapPointer_S () {
		
	    /* [ ][ ][ ]    [ ][ ][ ]
		   [ ][ ][ ] -> [ ][ ][o]
		   [ ][o][ ]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 2, 1);
		assertEquals(1, destination.x);
		assertEquals(2, destination.y);
	}
	
	@Test
	public void wrapPointer_SW () {
		
	    /* [ ][ ][ ]    [ ][ ][ ]
		   [ ][ ][ ] -> [ ][o][ ]
		   [o][ ][ ]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 2, 0);
		assertEquals(1, destination.x);
		assertEquals(1, destination.y);
	}
	
	@Test
	public void wrapPointer_W () {
		
	    /* [ ][ ][ ]    [ ][o][ ]
		   [o][ ][ ] -> [ ][ ][ ]
		   [ ][ ][ ]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 1, 0);
		assertEquals(0, destination.x);
		assertEquals(1, destination.y);
	}
	
	@Test
	public void wrapPointer_centre () {
		
	    /* [ ][ ][ ]    [ ][ ][o]
		   [ ][o][ ] -> [ ][ ][ ]
		   [ ][ ][ ]    [ ][ ][ ] */
		
		FSM[][] grid = new FSM[3][3];
		Point destination = FixedSizeLoom.wrapPointer(grid, 1, 1);
		assertEquals(0, destination.x);
		assertEquals(2, destination.y);
	}
}
