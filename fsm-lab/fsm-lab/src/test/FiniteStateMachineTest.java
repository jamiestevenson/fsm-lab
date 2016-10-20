package test;

import static org.junit.Assert.*;
import main.FiniteStateMachine;

import org.junit.Test;

public class FiniteStateMachineTest {

	@Test
	public void fsmConstructTest() {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertNotNull(fsm);
	}
	
	@Test
	public void fsmTickTest() {
		FiniteStateMachine fsm = new FiniteStateMachine();
		assertTrue(fsm.tick());
	}

}
