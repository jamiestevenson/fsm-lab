package test.fsms;

import static org.junit.Assert.*;
import main.fsms.FlipFlopFSM;
import main.model.FSM;

import org.junit.Test;

public class FlipFlopFSMTest {

	@Test
	public void fsmConstructTest () {
		FSM fsm = new FlipFlopFSM();
		assertNotNull(fsm);
	}
	
	@Test
	public void fsmTickTest () {
		FSM fsm = new FlipFlopFSM();
		assertTrue(fsm.tick());
	}
	
	@Test
	public void fsmGetState () {
		FSM fsm = new FlipFlopFSM();
		assertEquals(fsm.state(), "OFF");
	}
	
	@Test
	public void fsmGetNextState () {
		FSM fsm = new FlipFlopFSM();
		assertEquals(fsm.state(), "OFF");
		fsm.tick();
		assertEquals(fsm.state(), "ON");
	}

}
