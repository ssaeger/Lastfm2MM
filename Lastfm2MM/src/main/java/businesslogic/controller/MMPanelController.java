package businesslogic.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import businesslogic.model.MMModel;

public class MMPanelController implements ActionListener {
	private MMModel model;

	public MMPanelController(MMModel mmModel) {
		this.model = mmModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog((Component) e.getSource());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			model.setDatabase(file);
		}
	}

}
