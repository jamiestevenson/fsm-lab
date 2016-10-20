package test;

import static org.junit.Assert.*;

import java.awt.Dimension;

import main.FiniteStateMachine;
import main.Loom;

import org.junit.Test;

public class LoomTest {

	@Test
	public void defaultConstructTest () {
		Loom lm = new Loom();
		assertNotNull(lm);
	}
	
	@Test
	public void specificConstruct1x1Test () {
		Loom lm = new Loom(1,1);
		assertNotNull(lm);
	}
	
	@Test 
	public void defaultDimensionTest () {
		Loom lm = new Loom();
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}
	
	@Test 
	public void specifiedDimensionTest () {
		Loom lm = new Loom(3,3);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(3 == d.getHeight());
		assertTrue(3 == d.getWidth());
	}
	
	@Test 
	public void invalidDimensionTest () {
		Loom lm = new Loom(0,0);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}
	
	@Test
	public void addNullFsmTest () {
		Loom lm = new Loom();
		FiniteStateMachine fsm = null;
		assertFalse(lm.put(fsm));
	}
	
	@Test
	public void addActualFsmTest () {
		Loom lm = new Loom();
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertTrue(lm.put(fsm));
	}
	
	@Test
	public void addActualFsmToFullLoomTest () {
		Loom lm = new Loom(1,1);
		FiniteStateMachine fsmA = new FiniteStateMachine();
		FiniteStateMachine fsmB = new FiniteStateMachine();
		lm.put(fsmA);
		assertFalse(lm.put(fsmB));
	}
	
	@Test
	public void addFsmAndNullsDontMatterLoomTest () {
		Loom lm = new Loom(1,1);
		FiniteStateMachine fsmA = null;
		FiniteStateMachine fsmB = new FiniteStateMachine();
		lm.put(fsmA);
		assertTrue(lm.put(fsmB));
	}
	
}
