package businesslogic.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import businesslogic.model.interfaces.IMMModel;
import businesslogic.model.interfaces.IMMListener;

public class MMModel implements IMMModel {

	private File database;

	private List<IMMListener> listeners = new ArrayList<IMMListener>();

	public MMModel(File database) {
		setDatabase(database);
	}

	public MMModel(String databasePath) {
		setDatabase(databasePath);
	}

	@Override
	public File getDatabase() {
		return database;
	}

	public String getDatabasePath() {
		return database.getAbsolutePath();
	}

	@Override
	public void setDatabase(File database) {
		this.database = database;
		for (IMMListener listener : listeners) {
			listener.databasePathChanged(database.getAbsolutePath());
		}
	}

	public void setDatabase(String path) {
		this.database = new File(path);
		for (IMMListener listener : listeners) {
			listener.databasePathChanged(database.getAbsolutePath());
		}
	}

	@Override
	public void addMMModelListener(IMMListener mmModelListener) {
		listeners.add(mmModelListener);
	}

	@Override
	public void removeMMModelListener(IMMListener mmModelListener) {
		listeners.remove(mmModelListener);
	}

}
