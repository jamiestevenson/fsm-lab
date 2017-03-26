package main.model;

import java.util.Observable;
import javax.swing.Timer;

import main.ViewConfiguration;

/**
 * @author Jamie Stevenson
 *
 * This class represents the book-keeping aspects of the simulation such as timing and provides
 * high level (package) access to the rest of the current simulation.
 */

public class Simulation extends Observable implements ViewConfiguration {

	private Loom loom;
	private Timer timer;
	
	public Simulation(Loom loom) {
		this.loom = loom;
	}

	public void start() {
		this.tick();
		timer = new Timer(1000, e -> this.tick());
		timer.setInitialDelay(1);
		timer.start();
	}

	private boolean tick() {
		return loom.tick();
	}

}
