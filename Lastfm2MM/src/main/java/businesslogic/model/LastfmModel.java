package businesslogic.model;

import java.io.File;
import java.util.Observable;

public class LastfmModel extends Observable {
	public static final int PAGELIMIT = 200;
	private String username;
	private int totalPages;
	private int pageLimit;
	private File data;
	private String apiKey;

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

	public void setUsername(String username) {
		this.username = username;
		this.setChanged();
		this.notifyObservers("setUsername");
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		this.setChanged();
		this.notifyObservers("setTotalPages");
	}

	public void setTotalPages(String totalPages) {
		if (totalPages.equals("all"))
			setTotalPages(0);
		else
			setTotalPages(Integer.parseInt(totalPages));
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
		if (pageLimit > LastfmModel.PAGELIMIT)
			this.pageLimit = LastfmModel.PAGELIMIT;
		this.setChanged();
		this.notifyObservers("setPageLimit");

	}

	public File getData() {
		return data;
	}

	public String getDataPath() {
		return data.getAbsolutePath();
	}

	public void setData(File data) {
		this.data = data;
		this.setChanged();
		this.notifyObservers("setData");

	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
		this.setChanged();
		this.notifyObservers("setApiKey");
	}
}
