package businesslogic.controller;

import gui.view.MMPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import businesslogic.model.MMModel;
import businesslogic.model.interfaces.IMMListener;

public class MMPanelController {
	private MMPanel mmPanel;
	private MMModel mmModel;

	public MMPanelController(MMPanel mmPanel) {
		this.mmPanel = mmPanel;
		this.mmModel = new MMModel();
		addMMListener(mmPanel);
		addListener();
	}

	private void addListener() {
		this.mmPanel.setSelectDatabaseListener(new SelectDatabaseListener());
	}

	private void addMMListener(IMMListener mmListener) {
		this.mmModel.addMMListener(mmListener);
	}

	class SelectDatabaseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(mmPanel);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				mmModel.setDatabase(file);
			}
		}
	}
}
