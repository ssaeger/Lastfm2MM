package gui.view;

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

	private JTable lastfmTable;
	private JScrollPane lastfmScrollPane;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnDeleteAll;
	private JScrollPane mmScrollPane;
	private JTable mmTable;

	/**
	 * Create the panel.
	 */
	public DataPanel() {
		this.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(280px;default):grow"),
				ColumnSpec.decode("max(150px;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("100px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC,
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
						FormFactory.DEFAULT_ROWSPEC, }));

		createLastfmTable();
		createMMTable();
		addButtons();

	}

	private void addButtons() {

		btnDelete = new JButton("Delete");
		btnSave = new JButton("Save");
		btnDeleteAll = new JButton("Delete All");

		this.add(btnSave, "4, 12");
		this.add(btnDelete, "6, 12");
		this.add(btnDeleteAll, "8, 12");

	}

	private void createLastfmTable() {
		lastfmScrollPane = new JScrollPane();
		this.add(lastfmScrollPane, "1, 2, 1, 9, fill, fill");

		lastfmTable = new JTable();
		lastfmTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Title", "Artist", "Album", "Playcount",
						"Last Played" }));
		lastfmScrollPane.setViewportView(lastfmTable);
	}

	private void createMMTable() {
		mmScrollPane = new JScrollPane();
		this.add(mmScrollPane, "2, 2, 7, 9, fill, fill");

		mmTable = new JTable();
		mmTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Title", "Artist", "Album", "Playcount", "Last Played" }));
		mmScrollPane.setViewportView(mmTable);
	}

}
