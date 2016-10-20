package test;

import static org.junit.Assert.*;

import java.awt.Dimension;

import main.Loom;

import org.junit.Test;

public class LoomTest {

	@Test
	public void DefaultConstructTest () {
		Loom lm = new Loom();
		assertNotNull(lm);
	}
	
	@Test
	public void SpecificConstruct1x1Test () {
		Loom lm = new Loom(1,1);
		assertNotNull(lm);
	}
	
	@Test 
	public void DefaultDimensionTest () {
		Loom lm = new Loom();
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}
	
	@Test 
	public void SpecifiedDimensionTest () {
		Loom lm = new Loom(3,3);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(3 == d.getHeight());
		assertTrue(3 == d.getWidth());
	}
	
	@Test 
	public void InvalidDimensionTest () {
		Loom lm = new Loom(0,0);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}

}
