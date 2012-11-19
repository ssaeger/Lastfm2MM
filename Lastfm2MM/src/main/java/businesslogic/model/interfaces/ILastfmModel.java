package businesslogic.model.interfaces;

import java.io.File;

public interface ILastfmModel {
	public void setUsername(String username);

	public void setTotalPages(int totalPages);

	public void setPageLimit(int pageLimit);

	public void setTotalPages(String totalPages);

	public void setData(File data);

	public void setApiKey(String apiKey);

	void addLastfmListener(ILastfmListener lastfmListener);

	void removeLastfmListener(ILastfmListener lastfmListener);
}
