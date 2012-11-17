package businesslogic.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import gui.view.MMPanel;

public class MMPanelController {
	private MMPanel mmPanel;

	public MMPanelController() {
		this.mmPanel = new MMPanel();
		addListener();
	}

	private void addListener() {
		this.mmPanel.setSelectdatabaseListener(new SelectDatabaseListener());
	}

	class SelectDatabaseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(mmPanel);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				mmPanel.setTxtPath(file.getAbsolutePath());
			}
		}
	}

}
