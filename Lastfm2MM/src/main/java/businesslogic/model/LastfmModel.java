package businesslogic.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import businesslogic.model.interfaces.ILastfmListener;
import businesslogic.model.interfaces.ILastfmModel;

public class LastfmModel implements ILastfmModel {
	public static final int PAGELIMIT = 200;
	private String username;
	private int totalPages;
	private int pageLimit;
	private File data;
	private String apiKey;

	private List<ILastfmListener> listeners = new ArrayList<ILastfmListener>();

	public LastfmModel() {
		// initialize dummy data to avoid nullpointers at the first comparison
		this.username = "";
		this.totalPages = 0;
		this.pageLimit = PAGELIMIT;
		this.data = new File("");
		this.apiKey = "";
	}

	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		if (!this.username.equals(username)) {
			this.username = username;
			for (ILastfmListener listener : listeners) {
				listener.usernameChanged(username);
			}
		}
	}

	public void setUsernameNoUpdate(String username) {
		this.username = username;
	}

	public int getTotalPages() {
		return totalPages;
	}

	@Override
	public void setTotalPages(int totalPages) {
		if (this.totalPages != totalPages) {
			this.totalPages = totalPages;
			for (ILastfmListener listener : listeners) {
				listener.totalPagesChanged(Integer.toString(totalPages));
			}
		}
	}

	@Override
	public void setTotalPages(String totalPages) {
		if (totalPages.equals("all"))
			setTotalPages(0);
	}

	public int getPageLimit() {
		return pageLimit;
	}

	@Override
	public void setPageLimit(int pageLimit) {
		if (this.pageLimit != pageLimit) {
			this.pageLimit = pageLimit;
			if (pageLimit > LastfmModel.PAGELIMIT)
				this.pageLimit = LastfmModel.PAGELIMIT;
			for (ILastfmListener listener : listeners) {
				listener.pageLimitChanged(Integer.toString(pageLimit));
			}
		}
	}

	public File getData() {
		return data;
	}

	@Override
	public void setData(File data) {
		if (!this.data.getAbsolutePath().equals(data.getAbsolutePath())) {
			this.data = data;
			for (ILastfmListener listener : listeners) {
				listener.dataPathChanged(data.getAbsolutePath());
			}
		}
	}

	public String getApiKey() {
		return apiKey;
	}

	@Override
	public void setApiKey(String apiKey) {
		if (!this.apiKey.equals(apiKey)) {
			this.apiKey = apiKey;
			for (ILastfmListener listener : listeners) {
				listener.apiKeyChanged(apiKey);
			}
		}
	}

	@Override
	public void addLastfmListener(ILastfmListener lastfmListener) {
		listeners.add(lastfmListener);
	}

	@Override
	public void removeLastfmListener(ILastfmListener lastfmListener) {
		listeners.remove(lastfmListener);
	}

}
