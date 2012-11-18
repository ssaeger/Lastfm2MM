package businesslogic.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import businesslogic.model.MMModel;
import businesslogic.model.interfaces.IMMModelListener;

import gui.view.MMPanel;

public class MMPanelController {
	private MMPanel mmPanel;
	private MMModel mmModel;

	public MMPanelController(MMPanel mmPanel) {
		this.mmPanel = mmPanel;
		this.mmModel = new MMModel(mmPanel.getTxtPath());
		addMMModelListener(mmPanel);
		addListener();
	}

	private void addListener() {
		this.mmPanel.setSelectdatabaseListener(new SelectDatabaseListener());
	}
	
	private void addMMModelListener(IMMModelListener mmModelListener) {
		this.mmModel.addMMModelListener(mmModelListener);
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
