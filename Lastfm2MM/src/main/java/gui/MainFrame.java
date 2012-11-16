package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
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
				RowSpec.decode("90dlu:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		LastfmPanel lastfmPanel = new LastfmPanel();
		lastfmPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Last.fm Settings", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(lastfmPanel, "4, 2, fill, fill");
		
		MMPanel mmPanel = new MMPanel();
		mmPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "MediaMonkey Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(mmPanel, "6, 2, fill, fill");
		
		DataPanel dataPanel = new DataPanel();
		contentPane.add(dataPanel, "4, 4, 3, 1, fill, fill");
		
		JPanel statusPanel = new JPanel();
		contentPane.add(statusPanel, "4, 8, fill, fill");
		
		ControlPanel controlPanel = new ControlPanel();
		contentPane.add(controlPanel, "6, 8, fill, fill");
	}

}
