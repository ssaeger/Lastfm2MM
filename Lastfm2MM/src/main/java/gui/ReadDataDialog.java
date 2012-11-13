package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class ReadDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReadDataDialog dialog = new ReadDataDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReadDataDialog() {
		setTitle("New data or update old data?");
		setModal(true);
		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("85px"),
						ColumnSpec.decode("235px:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("104px"),
						RowSpec.decode("max(22dlu;default)"), }));
		{
			JTextPane txtpnIfYouAlready = new JTextPane();
			txtpnIfYouAlready.setBackground(SystemColor.menu);
			txtpnIfYouAlready.setEditable(false);
			txtpnIfYouAlready
					.setText("If you want to create a new dataset:\r\n\t Click \"New Data\"\r\n\r\nIf want to update an old dataset: \r\n\tSelect the file of the dataset\r\n\tClick \"Update Data\"");
			contentPanel.add(txtpnIfYouAlready, "2, 2, left, top");
		}
		{
			JLabel lblFile = new JLabel("File:");
			lblFile.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblFile, "1, 3, right, default");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "2, 3, fill, default");
			textField.setColumns(10);
		}
		{
			JButton btnSelectFile = new JButton("Select File");
			btnSelectFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(contentPanel);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
					}
				}
			});
			contentPanel.add(btnSelectFile, "4, 3");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewData = new JButton("New Data");
				btnNewData.setActionCommand("OK");
				buttonPane.add(btnNewData);
				getRootPane().setDefaultButton(btnNewData);
			}
			{
				JButton btnUpdateData = new JButton("Update Data");
				buttonPane.add(btnUpdateData);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
