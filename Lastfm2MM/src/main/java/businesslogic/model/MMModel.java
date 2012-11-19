package businesslogic.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import businesslogic.model.interfaces.IMMListener;
import businesslogic.model.interfaces.IMMModel;

public class MMModel implements IMMModel {

	private File database;

	private List<IMMListener> listeners = new ArrayList<IMMListener>();

	public MMModel() {
		// initialize dummy data to avoid nullpointers at the first comparison
		database = new File("");
	}

	@Override
	public void setDatabase(File database) {
		if (!this.database.getAbsolutePath().equals(database.getAbsolutePath())) {
			this.database = database;
			for (IMMListener listener : listeners) {
				listener.databasePathChanged(database.getAbsolutePath());
			}
		}
	}

	public void setDatabase(String path) {
		if (!this.database.getAbsolutePath().equals(path)) {
			this.database = new File(path);
			for (IMMListener listener : listeners) {
				listener.databasePathChanged(database.getAbsolutePath());
			}
		}
	}

	@Override
	public void addMMListener(IMMListener mmListener) {
		listeners.add(mmListener);
	}

	@Override
	public void removeMMListener(IMMListener mmListener) {
		listeners.remove(mmListener);
	}

}
