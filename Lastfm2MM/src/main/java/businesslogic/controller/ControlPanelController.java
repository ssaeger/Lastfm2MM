package businesslogic.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import businesslogic.model.ControlModel;

public class ControlPanelController implements ActionListener, ChangeListener {
	private ControlModel model;

	public ControlPanelController(ControlModel controlModel) {
		this.model = controlModel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setThreads(((JSlider) e.getSource()).getValue());
	}
}
