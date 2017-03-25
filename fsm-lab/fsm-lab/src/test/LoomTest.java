package test;

import static org.junit.Assert.*;

import main.FSM;
import main.FiniteStateMachine;
import main.FixedSizeLoom;
import main.Loom;

import org.junit.Test;

public class LoomTest {
	
	@Test
	public void addNullFsm_LoomTest () {
		Loom lm = new FixedSizeLoom();
		FSM fsm = null;
		assertFalse(lm.add(fsm));
	}
	
	@Test
	public void addActualFsm_LoomTest () {
		Loom lm = new FixedSizeLoom();
		FSM fsm = new FiniteStateMachine();
		assertTrue(lm.add(fsm));
	}
	
	@Test
	public void addActualFsmToFull_LoomTest () {
		Loom lm = new FixedSizeLoom(2,2);
		FSM fsmA = new FiniteStateMachine();
		FSM fsmB = new FiniteStateMachine();
		FSM fsmC = new FiniteStateMachine();
		FSM fsmD = new FiniteStateMachine();
		lm.add(fsmA);
		lm.add(fsmB);
		lm.add(fsmC);
		lm.add(fsmD);
		
		assertFalse(lm.add(new FiniteStateMachine()));
	}
	
	@Test
	public void addFsmAndNullsDontMatter_LoomTest () {
		Loom lm = new FixedSizeLoom(1,1);
		FSM fsmA = null;
		FSM fsmB = new FiniteStateMachine();
		lm.add(fsmA);
		assertTrue(lm.add(fsmB));
	}
	
	@Test
	public void noFsm_inTopLeft_LoomTest () {
		Loom lm = new FixedSizeLoom(10,10);
		FSM fsmReturned = lm.getCellContents(0,0);
		assertNull(fsmReturned);
	}
	
	@Test
	public void oneFsm_inTopLeft_LoomTest () {
		Loom lm = new FixedSizeLoom(10,10);
		FSM fsmA = new FiniteStateMachine();
		lm.add(fsmA);
		FSM fsmReturned = lm.getCellContents(0,0);
		assertTrue(fsmA == fsmReturned);
	}
	
	@Test
	public void oneFsm_inOneOne_LoomTest () {
		Loom lm = new FixedSizeLoom(10,10);
		FSM fsmA = new FiniteStateMachine();
		lm.put(fsmA, 1, 1);
		FSM fsmReturned = lm.getCellContents(1,1);
		assertTrue(fsmA == fsmReturned);
	}
	
	@Test
	public void autoAdd_oneIn_LoomTest () {
		Loom lm = new FixedSizeLoom(10,10);
		FSM fsmA = new FiniteStateMachine();
		lm.add(fsmA);
		FSM fsmB = new FiniteStateMachine();
		lm.add(fsmB);
		FSM fsmReturned = lm.getCellContents(0,0);
		assertTrue(fsmA == fsmReturned);
		fsmReturned = lm.getCellContents(1,0);
		assertTrue(fsmB == fsmReturned);
	}
	
	@Test
	public void autoAdd_twoIn_LoomTest () {
		Loom lm = new FixedSizeLoom(10,10);
		FSM fsmA = new FiniteStateMachine();
		lm.add(fsmA);
		FSM fsmB = new FiniteStateMachine();
		lm.add(fsmB);
		FSM fsmC = new FiniteStateMachine();
		lm.add(fsmC);
		FSM fsmReturned = lm.getCellContents(0,0);
		assertTrue(fsmA == fsmReturned);
		fsmReturned = lm.getCellContents(1,0);
		assertTrue(fsmB == fsmReturned);
		fsmReturned = lm.getCellContents(0,1);
		assertTrue(fsmC == fsmReturned);
	}
}
