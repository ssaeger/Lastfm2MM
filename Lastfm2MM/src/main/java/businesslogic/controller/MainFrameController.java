package businesslogic.controller;

import gui.view.MainFrame;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class MainFrameController {

	public void showView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
