package businesslogic.controller;

import gui.view.ControlPanel;
import gui.view.LastfmPanel;
import gui.view.MMPanel;
import gui.view.MainFrame;

import javax.swing.UIManager;

import businesslogic.model.ControlModel;
import businesslogic.model.LastfmModel;
import businesslogic.model.MMModel;

public class MainFrameController {

	private MainFrame mainFrame;

	public MainFrameController() {
		showView();
	}

	public void showView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame(createMMPanel(), createLastfmPanel(),
					createControlPanel());
			mainFrame.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private MMPanel createMMPanel() {
		MMModel mmModel = new MMModel();
		return new MMPanel(mmModel);
	}

	private LastfmPanel createLastfmPanel() {
		LastfmModel lastfmModel = new LastfmModel();
		return new LastfmPanel(lastfmModel);
	}

	private ControlPanel createControlPanel() {
		ControlModel controlModel = new ControlModel();
		return new ControlPanel(controlModel);
	}
}
