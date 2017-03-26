package test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.fsms.FlipFlopFSMTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FlipFlopFSMTest.class,
	FixedSizeLoomTest.class,
	LoomTest.class,
})

public class RunAllTests {

}
