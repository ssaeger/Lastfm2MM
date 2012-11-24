package businesslogic.controller;

import gui.view.MainFrame;
import gui.view.StatusPanel;

import javax.swing.UIManager;

public class MainFrameController {

	private MainFrame mainFrame;

	public MainFrameController() {
		showView();
		MMPanelController mmPanelController = new MMPanelController(
				mainFrame.getMmPanel());
		LastfmPanelController lastfmPanelController = new LastfmPanelController(
				mainFrame.getLastfmPanel());
	}

	public void showView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();
			mainFrame.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
