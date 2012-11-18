package businesslogic.model.interfaces;

import java.io.File;

public interface IMMModel {
	 void setDatabase(File database);
	 File getDatabase();
	 void addMMModelListener(IMMListener mmModelListener);
	 void removeMMModelListener(IMMListener mmModelListener);
}
