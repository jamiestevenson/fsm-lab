package main;

import main.fsms.FlipFlopFSM;
import main.model.FixedSizeLoom;
import main.model.Loom;
import main.model.Simulation;
import main.view.SwingView;

/**
 * @author Jamie Stevenson
 *
 * Launches the application, does little else.
 */

public class Main {

	public static void main (String[] args) {
		Loom loom = new FixedSizeLoom();
		Simulation sim = new Simulation(loom);
		populate(loom);
		View v = new SwingView(sim);
		sim.addObserver(v);
		sim.start();
	}

	private static void populate(Loom loom) {
		loom.add(new FlipFlopFSM());
		loom.add(new FlipFlopFSM());
		loom.add(new FlipFlopFSM());
		loom.add(new FlipFlopFSM());
		
	}
	
}
