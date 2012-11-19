package businesslogic.model.interfaces;

public interface ILastfmListener {
	void dataPathChanged(String newDataPath);

	void usernameChanged(String newUsername);

	void totalPagesChanged(String newTotalPages);

	void pageLimitChanged(String newPagelimit);

	void apiKeyChanged(String newApiKey);
}
