package businesslogic.controller;

import gui.view.LastfmPanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.swing.JFileChooser;

import businesslogic.model.LastfmModel;

public class LastfmPanelController implements ActionListener, FocusListener {

	private LastfmModel lastfmModel;

	public LastfmPanelController(LastfmModel lastfmModel) {
		this.lastfmModel = lastfmModel;
		// updateModel();
	}

//	 private void updateModel() {
//	 this.lastfmModel.setUsername(lastfmPanel.getUsernameString());
//	 this.lastfmModel.setTotalPages(lastfmPanel.getTotalPagesString());
//	 this.lastfmModel.setPageLimit(Integer.parseInt(lastfmPanel
//	 .getPageLimitString()));
//	 this.lastfmModel.setApiKey(lastfmPanel.getApiKeyString());
//	 }

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Select Data")) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog((Component) e.getSource());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				lastfmModel.setData(file);
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// do nothing
	}

	@Override
	public void focusLost(FocusEvent e) {
		switch (e.getComponent().getName()) {
		case "username":
			lastfmModel
					.setUsername(((LastfmPanel) e.getComponent().getParent())
							.getUsernameString());
			break;
		case "totalPages":
			lastfmModel.setTotalPages(((LastfmPanel) e.getComponent()
					.getParent()).getTotalPagesString());
			break;
		case "pageLimit":
			lastfmModel.setPageLimit(Integer.parseInt(((LastfmPanel) e
					.getComponent().getParent()).getPageLimitString()));
			break;
		case "apiKey":
			lastfmModel.setApiKey(((LastfmPanel) e.getComponent().getParent())
					.getApiKeyString());
			break;
		case "dataPath":
			lastfmModel.setData(new File(((LastfmPanel) e.getComponent()
					.getParent()).getDataPathString()));
			break;
		default:
			break;
		}

	}

}
