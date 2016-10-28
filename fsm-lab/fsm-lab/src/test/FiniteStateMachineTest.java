package test;

import static org.junit.Assert.*;
import main.FiniteStateMachine;

import org.junit.Test;

public class FiniteStateMachineTest {

	@Test
	public void fsmConstructTest () {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertNotNull(fsm);
	}
	
	@Test
	public void fsmTickTest () {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertTrue(fsm.tick());
	}
	
	@Test
	public void fsmGetState () {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertEquals(fsm.state(), "OFF");
	}
	
	@Test
	public void fsmGetNextState () {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertEquals(fsm.state(), "OFF");
		fsm.tick();
		assertEquals(fsm.state(), "ON");
	}

}
