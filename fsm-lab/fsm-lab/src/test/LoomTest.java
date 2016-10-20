package test;

import static org.junit.Assert.*;
import main.Loom;

import org.junit.Test;

public class LoomTest {

	@Test
	public void ConstructTest() {
		Loom lm = new Loom();
		assertNotNull(lm);
	}

}
