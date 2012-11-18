package businesslogic.model.interfaces;

import java.io.File;

public interface IMMModel {
	 void setDatabase(File database);
	 File getDatabase();
	 void addMMModelListener(IMMModelListener mmModelListener);
	 void removeMMModelListener(IMMModelListener mmModelListener);
}
