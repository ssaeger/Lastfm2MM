package businesslogic.model;

import java.io.File;
import java.util.Observable;

public class MMModel extends Observable {

	private File database;

	public MMModel() {
		// initialize dummy data to avoid nullpointers at the first comparison
		database = new File("");
	}

	public void setDatabase(File database) {
		this.database = database;
		this.setChanged();
		this.notifyObservers("setDatabase");
	}

	public void setDatabase(String path) {
		this.database = new File(path);
		this.setChanged();
		this.notifyObservers("setDatabase");

	}

	public String getDatabasePath() {
		return database.getAbsolutePath();
	}
}
