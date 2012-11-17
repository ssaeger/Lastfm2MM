package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class LastfmPanel extends JPanel {

	private JTextField txtUsername;
	private JTextField txtTotalPages;
	private JTextField txtPageLimit;
	private JTextField txtApiKey;
	private JTextField texField;
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
	public LastfmPanel() {

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
		txtUsername.setText("zaega");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtUsername, "4, 2, left, default");
		txtUsername.setColumns(10);

		lblLogo = new JLabel("");
		lblLogo.setIcon(null);
		this.add(lblLogo, "5, 2, 1, 5, center, default");

		lblTotalPages = new JLabel("Total-Pages:");
		this.add(lblTotalPages, "2, 4, right, default");

		txtTotalPages = new JTextField();
		txtTotalPages.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPages.setText("all");
		this.add(txtTotalPages, "4, 4, left, default");
		txtTotalPages.setColumns(10);

		lblPageLimit = new JLabel("Page-Limit:");
		this.add(lblPageLimit, "2, 6, right, default");

		txtPageLimit = new JTextField();
		txtPageLimit.setText("200");
		txtPageLimit.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtPageLimit, "4, 6, left, default");
		txtPageLimit.setColumns(10);

		lblApiKey = new JLabel("API-Key:");
		this.add(lblApiKey, "2, 8, right, default");

		txtApiKey = new JTextField();
		txtApiKey.setText("30d3d4877f08d37cdbba1a8ac3ebf982");
		txtApiKey.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtApiKey, "4, 8, 2, 1");
		txtApiKey.setColumns(10);

		btnGroup = new ButtonGroup();

		rdbtnNewData = new JRadioButton("New Data");
		rdbtnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texField.setEnabled(false);
				btnSelectData.setEnabled(false);
			}
		});
		rdbtnNewData.setSelected(true);
		add(rdbtnNewData, "2, 10");
		btnGroup.add(rdbtnNewData);

		rdbtnUpdateData = new JRadioButton("Update Data");
		rdbtnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texField.setEnabled(true);
				btnSelectData.setEnabled(true);
			}
		});
		add(rdbtnUpdateData, "4, 10");
		btnGroup.add(rdbtnUpdateData);

		btnSelectData = new JButton("Select Data");
		btnSelectData.setEnabled(false);
		btnSelectData.setActionCommand("Select Data");
		btnSelectData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(LastfmPanel.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					texField.setText(file.getAbsolutePath());
				}
			}
		});

		texField = new JTextField();
		texField.setEnabled(false);
		add(texField, "2, 12, 4, 1, fill, default");
		texField.setColumns(10);
		add(btnSelectData, "5, 14");
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getTxtTotalPages() {
		return txtTotalPages.getText();
	}

	public String getTxtPageLimit() {
		return txtPageLimit.getText();
	}

	public String getTxtApiKey() {
		return txtApiKey.getText();
	}

	public String getTexField() {
		return texField.getText();
	}

}
