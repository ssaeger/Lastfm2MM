package businesslogic.controller;

import gui.view.LastfmPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import businesslogic.model.LastfmModel;
import businesslogic.model.interfaces.ILastfmListener;

public class LastfmPanelController {
	private LastfmPanel lastfmPanel;
	private LastfmModel lastfmModel;

	public LastfmPanelController(LastfmPanel lastfmPanel) {
		this.lastfmPanel = lastfmPanel;
		this.lastfmModel = new LastfmModel();
		addLastfmListener(lastfmPanel);
		updateModel();
		addListener();
	}

	private void updateModel() {
		this.lastfmModel.setUsername(lastfmPanel.getUsernameString());
		this.lastfmModel.setTotalPages(lastfmPanel.getTotalPagesString());
		this.lastfmModel.setPageLimit(Integer.parseInt(lastfmPanel
				.getPageLimitString()));
		this.lastfmModel.setApiKey(lastfmPanel.getApiKeyString());
	}

	private void addListener() {
		this.lastfmPanel.setSelectDataListener(new SelectDataListener());
		this.lastfmPanel.setUsernameListener(new SetUsernameListener());
		this.lastfmPanel.setPageLimitListener(new SetPageLimitListener());
		this.lastfmPanel.setTotalPagesListener(new SetTotalPagesListener());
		this.lastfmPanel.setApiKeyListener(new SetApiKeyListener());
		this.lastfmPanel.setDataPathListener(new SetDataPathListener());
	}

	private void addLastfmListener(ILastfmListener lastfmListener) {
		this.lastfmModel.addLastfmListener(lastfmListener);
	}

	class SelectDataListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(lastfmPanel);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				lastfmModel.setData(file);
			}
		}
	}

	class SetUsernameListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent e) {
			try {
				lastfmModel.setUsernameNoUpdate(e.getDocument().getText(0,
						e.getDocument().getLength()));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			try {
				lastfmModel.setUsernameNoUpdate(e.getDocument().getText(0,
						e.getDocument().getLength()));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			try {
				lastfmModel.setUsernameNoUpdate(e.getDocument().getText(0,
						e.getDocument().getLength()));
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class SetTotalPagesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class SetPageLimitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class SetApiKeyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class SetDataPathListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}
