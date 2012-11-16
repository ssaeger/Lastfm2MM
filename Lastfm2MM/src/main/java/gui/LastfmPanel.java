package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
	
	/**
	 * Create the this.
	 */
	public LastfmPanel() {

		this.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(62dlu;default):grow"),
				ColumnSpec.decode("max(80dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblUsername = new JLabel("Username:");
		this.add(lblUsername, "2, 2, right, default");
		
		txtUsername = new JTextField();
		txtUsername.setText("zaega");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtUsername, "4, 2, left, default");
		txtUsername.setColumns(10);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(null);
		this.add(lblLogo, "5, 2, 1, 5, center, default");
		
		JLabel lblTotalPages = new JLabel("Total-Pages:");
		this.add(lblTotalPages, "2, 4, right, default");
		
		txtTotalPages = new JTextField();
		txtTotalPages.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPages.setText("all");
		this.add(txtTotalPages, "4, 4, left, default");
		txtTotalPages.setColumns(10);
		
		JLabel lblPageLimit = new JLabel("Page-Limit:");
		this.add(lblPageLimit, "2, 6, right, default");
		
		txtPageLimit = new JTextField();
		txtPageLimit.setText("200");
		txtPageLimit.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtPageLimit, "4, 6, left, default");
		txtPageLimit.setColumns(10);
		
		JLabel lblApiKey = new JLabel("API-Key:");
		this.add(lblApiKey, "2, 8, right, default");
		
		txtApiKey = new JTextField();
		txtApiKey.setText("30d3d4877f08d37cdbba1a8ac3ebf982");
		txtApiKey.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(txtApiKey, "4, 8, 2, 1");
		txtApiKey.setColumns(10);
	}

}
