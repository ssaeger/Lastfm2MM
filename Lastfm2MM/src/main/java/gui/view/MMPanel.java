package gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.controller.MMPanelController;
import businesslogic.model.MMModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MMPanel extends JPanel implements Observer {
	private MMModel model;
	private MMPanelController controller;

	private JTextField txtPath;
	private JButton btnSelectDatabase;
	private JLabel lblDatabase;

	/**
	 * Create the panel.
	 */
	public MMPanel(MMModel mmModel) {
		this.model = mmModel;
		model.addObserver(this);
		controller = new MMPanelController(model);

		setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(44dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(135dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(0dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		lblDatabase = new JLabel("Database:");
		add(lblDatabase, "2, 4, right, default");

		txtPath = new JTextField();
		add(txtPath, "4, 4, fill, default");
		txtPath.setColumns(10);

		btnSelectDatabase = new JButton("Select Database");
		btnSelectDatabase.addActionListener(controller);
		add(btnSelectDatabase, "6, 4");

	}

	public String getTxtPath() {
		return txtPath.getText();
	}

	public void setTxtPath(String path) {
		this.txtPath.setText(path);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (model == o) {
			if (arg.equals("setDatabase")) {
				txtPath.setText(model.getDatabasePath());
			}
		}
	}
}
