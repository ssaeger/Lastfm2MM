package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businesslogic.controller.LastfmPanelController;
import businesslogic.model.LastfmModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class LastfmPanel extends JPanel implements Observer {

	private LastfmModel model;
	private LastfmPanelController controller;

	private JTextField txtUsername;
	private JTextField txtTotalPages;
	private JTextField txtPageLimit;
	private JTextField txtApiKey;
	private JTextField txtDataPath;
	private JButton btnSelectData;
	private JLabel lblPageLimit;
	private JLabel lblApiKey;
	private JRadioButton rdbtnNewData;
	private JRadioButton rdbtnUpdateData;
	private ButtonGroup btnGroup;
	private JLabel lblLogo;
	private JLabel lblTotalPages;
	private JLabel lblUsername;

	/**
	 * Create the this.
	 */
	public LastfmPanel(LastfmModel model) {
		this.model = model;
		model.addObserver(this);
		controller = new LastfmPanelController(model);

		this.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(62dlu;default):grow"),
				ColumnSpec.decode("max(80dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, }));

		lblUsername = new JLabel("Username:");
		this.add(lblUsername, "2, 2, right, default");

		txtUsername = new JTextField();
		txtUsername.setName("username");
		txtUsername.setText("zaega");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.addFocusListener(controller);
		this.add(txtUsername, "4, 2, left, default");
		txtUsername.setColumns(10);

		lblLogo = new JLabel("");
		lblLogo.setIcon(null);
		this.add(lblLogo, "5, 2, 1, 5, center, default");

		lblTotalPages = new JLabel("Total-Pages:");
		this.add(lblTotalPages, "2, 4, right, default");

		txtTotalPages = new JTextField();
		txtTotalPages.setName("totalPages");
		txtTotalPages.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPages.setText("all");
		txtTotalPages.addFocusListener(controller);
		this.add(txtTotalPages, "4, 4, left, default");
		txtTotalPages.setColumns(10);

		lblPageLimit = new JLabel("Page-Limit:");
		this.add(lblPageLimit, "2, 6, right, default");

		txtPageLimit = new JTextField();
		txtPageLimit.setName("pageLimit");
		txtPageLimit.setText("200");
		txtPageLimit.setHorizontalAlignment(SwingConstants.CENTER);
		txtPageLimit.addFocusListener(controller);
		this.add(txtPageLimit, "4, 6, left, default");
		txtPageLimit.setColumns(10);

		lblApiKey = new JLabel("API-Key:");
		this.add(lblApiKey, "2, 8, right, default");

		txtApiKey = new JTextField();
		txtApiKey.setName("apiKey");
		txtApiKey.setText("30d3d4877f08d37cdbba1a8ac3ebf982");
		txtApiKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtApiKey.addFocusListener(controller);
		this.add(txtApiKey, "4, 8, 2, 1");
		txtApiKey.setColumns(10);

		btnGroup = new ButtonGroup();

		rdbtnNewData = new JRadioButton("New Data");
		rdbtnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDataPath.setEnabled(false);
				btnSelectData.setEnabled(false);
			}
		});
		rdbtnNewData.setSelected(true);
		add(rdbtnNewData, "2, 10");
		btnGroup.add(rdbtnNewData);

		rdbtnUpdateData = new JRadioButton("Update Data");
		rdbtnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDataPath.setEnabled(true);
				btnSelectData.setEnabled(true);
			}
		});
		add(rdbtnUpdateData, "4, 10");
		btnGroup.add(rdbtnUpdateData);

		btnSelectData = new JButton("Select Data");
		btnSelectData.setName("selectData");
		btnSelectData.setEnabled(false);
		btnSelectData.addActionListener(controller);
		this.add(btnSelectData, "5, 14");

		txtDataPath = new JTextField();
		txtDataPath.setName("dataPath");
		txtDataPath.setEnabled(false);
		txtDataPath.addFocusListener(controller);
		this.add(txtDataPath, "2, 12, 4, 1, fill, default");
		txtDataPath.setColumns(10);

		initModel();
	}

	private void initModel() {
		model.setUsername(getUsernameString());
		model.setTotalPages(getTotalPagesString());
		model.setPageLimit(Integer.parseInt(getPageLimitString()));
		model.setApiKey(getApiKeyString());
	}

	public String getUsernameString() {
		return txtUsername.getText();
	}

	public String getTotalPagesString() {
		return txtTotalPages.getText();
	}

	public String getPageLimitString() {
		return txtPageLimit.getText();
	}

	public String getApiKeyString() {
		return txtApiKey.getText();
	}

	public String getDataPathString() {
		return txtDataPath.getText();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (model == o) {
			if (arg.equals("setUsername")) {
				txtUsername.setText(model.getUsername());
			} else if (arg.equals("setTotalPages")) {
				txtTotalPages.setText(String.valueOf(model.getTotalPages()));
			} else if (arg.equals("setPageLimit")) {
				txtPageLimit.setText(String.valueOf(model.getPageLimit()));
			} else if (arg.equals("setData")) {
				txtDataPath.setText(model.getDataPath());
			} else if (arg.equals("setApiKey")) {
				txtApiKey.setText(model.getApiKey());
			}
		}
	}
}
