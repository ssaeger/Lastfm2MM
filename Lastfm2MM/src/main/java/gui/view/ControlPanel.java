package gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import businesslogic.controller.ControlPanelController;
import businesslogic.model.ControlModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ControlPanel extends JPanel implements Observer {
	private ControlModel model;
	private ControlPanelController controller;

	private JSlider sliderThreads;
	private JButton btnReadData;
	private JLabel lblThreads;

	/**
	 * Create the panel.
	 */
	public ControlPanel(ControlModel controlModel) {
		this.model = controlModel;
		model.addObserver(this);
		controller = new ControlPanelController(model);

		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("57px"),
				ColumnSpec.decode("43px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("83px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("45px"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		lblThreads = new JLabel("Threads:");
		add(lblThreads, "2, 2, left, center");

		sliderThreads = new JSlider();
		sliderThreads.setMajorTickSpacing(1);
		sliderThreads.setSnapToTicks(true);
		sliderThreads.setPaintTicks(true);
		sliderThreads.setPaintLabels(true);
		sliderThreads.setMinimum(1);
		sliderThreads.setMaximum(4);
		sliderThreads.addChangeListener(controller);
		this.add(sliderThreads, "4, 2, left, top");
		btnReadData = new JButton("Read data");
		btnReadData.addActionListener(controller);
		this.add(btnReadData, "6, 4, left, center");

		initModel();
	}

	private void initModel() {
		sliderThreads.setValue(model.getThreads());

	}

	public int getSliderThreads() {
		return sliderThreads.getValue();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (model == o) {
			if (arg.equals("setThreads")) {
				sliderThreads.setValue(model.getThreads());
			}
		}
	}

}
