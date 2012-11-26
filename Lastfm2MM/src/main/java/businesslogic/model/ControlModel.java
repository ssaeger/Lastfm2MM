package businesslogic.model;

import java.util.Observable;

public class ControlModel extends Observable {

	private int threads;

	public ControlModel() {
		this.threads = 2;
	}

	public ControlModel(int threads) {
		setThreads(threads);
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
		this.setChanged();
		this.notifyObservers("setThreads");
	}
}
