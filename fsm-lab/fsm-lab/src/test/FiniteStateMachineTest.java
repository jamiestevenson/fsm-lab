package test;

import static org.junit.Assert.*;
import main.FSM;
import main.FiniteStateMachine;

import org.junit.Test;

public class FiniteStateMachineTest {

	@Test
	public void fsmConstructTest () {
		FSM fsm = new FiniteStateMachine();
		assertNotNull(fsm);
	}
	
	@Test
	public void fsmTickTest () {
		FSM fsm = new FiniteStateMachine();
		assertTrue(fsm.tick());
	}
	
	@Test
	public void fsmGetState () {
		FSM fsm = new FiniteStateMachine();
		assertEquals(fsm.state(), "OFF");
	}
	
	@Test
	public void fsmGetNextState () {
		FSM fsm = new FiniteStateMachine();
		assertEquals(fsm.state(), "OFF");
		fsm.tick();
		assertEquals(fsm.state(), "ON");
	}

}
