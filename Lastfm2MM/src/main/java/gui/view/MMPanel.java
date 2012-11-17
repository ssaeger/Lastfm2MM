package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;

public class MMPanel extends JPanel {
	private JTextField txtPath;
	private JButton btnSelectDatabase;
	private JLabel lblDatabase;

	/**
	 * Create the panel.
	 */
	public MMPanel() {
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
		btnSelectDatabase.setActionCommand("Select Data");
//		btnSelectDatabase.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				JFileChooser fc = new JFileChooser();
//				int returnVal = fc.showOpenDialog(MMPanel.this);
//
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					File file = fc.getSelectedFile();
//					txtPath.setText(file.getAbsolutePath());
//				}
//			}
//		});
		add(btnSelectDatabase, "6, 4");

	}

	public String getTxtPath() {
		return txtPath.getText();
	}

	public void setTxtPath(String path) {
		this.txtPath.setText(path);
	}
	
	public void setSelectdatabaseListener(ActionListener aListener) {
		this.btnSelectDatabase.addActionListener(aListener);
	}
}
