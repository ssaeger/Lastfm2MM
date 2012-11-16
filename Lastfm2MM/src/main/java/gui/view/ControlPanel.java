package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class ControlPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ControlPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("57px"),
				ColumnSpec.decode("43px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("200px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("83px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("45px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblThreads = new JLabel("Threads:");
		add(lblThreads, "2, 2, left, center");

		JSlider sliderThreads = new JSlider();
		sliderThreads.setMajorTickSpacing(1);
		sliderThreads.setValue(2);
		sliderThreads.setSnapToTicks(true);
		sliderThreads.setPaintTicks(true);
		sliderThreads.setPaintLabels(true);
		sliderThreads.setMinimum(1);
		sliderThreads.setMaximum(4);
		this.add(sliderThreads, "4, 2, left, top");
		
				JButton btnReadData = new JButton("Read data");
				btnReadData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ReadDataDialog readDataDialog = new ReadDataDialog();
						readDataDialog.setVisible(true);
					}
				});
				this.add(btnReadData, "6, 4, left, center");
	}

}
