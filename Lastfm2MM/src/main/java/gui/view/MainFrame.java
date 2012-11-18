package gui.view;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private LastfmPanel lastfmPanel;
	private MMPanel mmPanel;
	private DataPanel dataPanel;
	private JPanel statusPanel;
	private ControlPanel controlPanel;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Lastfm2MM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("140dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		lastfmPanel = new LastfmPanel();
		lastfmPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0)), "Last.fm Settings", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(lastfmPanel, "4, 2, fill, fill");

		mmPanel = new MMPanel();
		mmPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"MediaMonkey Settings", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		contentPane.add(mmPanel, "6, 2, fill, fill");

		dataPanel = new DataPanel();
		contentPane.add(dataPanel, "4, 4, 3, 1, fill, fill");

		statusPanel = new JPanel();
		contentPane.add(statusPanel, "4, 8, fill, fill");

		controlPanel = new ControlPanel();
		contentPane.add(controlPanel, "6, 8, fill, fill");
	}

	public MainFrame(LastfmPanel lastfmPanel, MMPanel mmPanel,
			DataPanel dataPanel, JPanel statusPanel, ControlPanel controlPanel)
			throws HeadlessException {
		setTitle("Lastfm2MM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("140dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lastfmPanel = lastfmPanel;
		this.mmPanel = mmPanel;
		this.dataPanel = dataPanel;
		this.statusPanel = statusPanel;
		this.controlPanel = controlPanel;
		insertPanels();
	}
	
	public LastfmPanel getLastfmPanel() {
		return lastfmPanel;
	}

	public MMPanel getMmPanel() {
		return mmPanel;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public JPanel getStatusPanel() {
		return statusPanel;
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	private void insertPanels() {
		lastfmPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0)), "Last.fm Settings", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(lastfmPanel, "4, 2, fill, fill");

		mmPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"MediaMonkey Settings", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		contentPane.add(mmPanel, "6, 2, fill, fill");

		contentPane.add(dataPanel, "4, 4, 3, 1, fill, fill");

		contentPane.add(statusPanel, "4, 8, fill, fill");

		contentPane.add(controlPanel, "6, 8, fill, fill");
	}
}
