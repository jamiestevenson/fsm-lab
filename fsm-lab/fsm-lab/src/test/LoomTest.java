package test;

import static org.junit.Assert.*;

import java.awt.Dimension;

import main.FiniteStateMachine;
import main.Loom;

import org.junit.Test;

public class LoomTest {

	@Test
	public void defaultConstruct_LoomTest () {
		Loom lm = new Loom();
		assertNotNull(lm);
	}
	
	@Test
	public void specificConstruct1x1_LoomTest () {
		Loom lm = new Loom(1,1);
		assertNotNull(lm);
	}
	
	@Test 
	public void defaultDimension_LoomTest () {
		Loom lm = new Loom();
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}
	
	@Test 
	public void specifiedDimension_LoomTest () {
		Loom lm = new Loom(3,3);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(3 == d.getHeight());
		assertTrue(3 == d.getWidth());
	}
	
	@Test 
	public void invalidDimension_LoomTest () {
		Loom lm = new Loom(0,0);
		Dimension d = lm.dimension();
		assertNotNull(d);
		assertTrue(1 == d.getHeight());
		assertTrue(1 == d.getWidth());
	}
	
	@Test
	public void addNullFsm_LoomTest () {
		Loom lm = new Loom();
		FiniteStateMachine fsm = null;
		assertFalse(lm.add(fsm));
	}
	
	@Test
	public void addActualFsm_LoomTest () {
		Loom lm = new Loom();
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertTrue(lm.add(fsm));
	}
	
	@Test
	public void addActualFsmToFull_LoomTest () {
		Loom lm = new Loom(1,1);
		FiniteStateMachine fsmA = new FiniteStateMachine();
		FiniteStateMachine fsmB = new FiniteStateMachine();
		lm.add(fsmA);
		assertFalse(lm.add(fsmB));
	}
	
	@Test
	public void addFsmAndNullsDontMatter_LoomTest () {
		Loom lm = new Loom(1,1);
		FiniteStateMachine fsmA = null;
		FiniteStateMachine fsmB = new FiniteStateMachine();
		lm.add(fsmA);
		assertTrue(lm.add(fsmB));
	}
	
	@Test
	public void oneFsm_inTopLeft_LoomTest () {
		Loom lm = new Loom(10,10);
		FiniteStateMachine fsmA = new FiniteStateMachine();
		lm.add(fsmA);
		FiniteStateMachine fsmReturned = lm.getCellContents(0,0);
		assertTrue(fsmA == fsmReturned);
		
	}
	
}
