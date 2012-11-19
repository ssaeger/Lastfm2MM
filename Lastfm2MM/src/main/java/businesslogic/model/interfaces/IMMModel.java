package businesslogic.model.interfaces;

import java.io.File;

public interface IMMModel {
	void setDatabase(File database);

	void addMMListener(IMMListener mmListener);

	void removeMMListener(IMMListener mmListener);
}
