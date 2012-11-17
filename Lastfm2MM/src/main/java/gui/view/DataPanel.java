package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class DataPanel extends JPanel {

	private JTable table;
	private JScrollPane lastfmScrollPane;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnDeleteAll;
	private JScrollPane mmScrollPane;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public DataPanel() {
		this.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(280px;default):grow"),
				ColumnSpec.decode("max(150px;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("100px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		lastfmScrollPane = new JScrollPane();
		this.add(lastfmScrollPane, "1, 2, 1, 9, fill, fill");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Title", "Artist", "Album", "Playcount", "Last Played" }));
		lastfmScrollPane.setViewportView(table);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		mmScrollPane = new JScrollPane();
		this.add(mmScrollPane, "2, 2, 7, 9, fill, fill");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Title", "Artist", "Album", "Playcount", "Last Played" }));
		mmScrollPane.setViewportView(table_1);

		btnSave = new JButton("Save");
		this.add(btnSave, "4, 12");
		this.add(btnDelete, "6, 12");

		btnDeleteAll = new JButton("Delete All");
		this.add(btnDeleteAll, "8, 12");
	}

}
