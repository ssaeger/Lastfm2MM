package gui.view;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class StatusPanel extends JPanel {

	private JTextPane statusTextPane;

	/**
	 * Create the panel.
	 */
	public StatusPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		statusTextPane = new JTextPane();
		statusTextPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(statusTextPane);
		add(scrollPane);
		redirectSystemStreams();
	}

	public String getStatus() {
		return statusTextPane.getText();
	}

	public void setStatus(String newStatus) {
		this.statusTextPane.setText(newStatus);
	}

	public void appendStatus(String newStatus) {
		this.statusTextPane.setText(statusTextPane.getText().concat(newStatus));
	}

	/**
	 * Redirecting System.out to JTextPane by override the write() methods of
	 * OutputStream to append the text to the text pane instead.
	 * http://unserializableone
	 * .blogspot.co.at/2009/01/redirecting-systemout-and-systemerr-to.html
	 */
	private void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(final int b) throws IOException {
				appendStatus(String.valueOf(b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				appendStatus(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				write(b, 0, b.length);
			}
		};

		System.setOut(new PrintStream(out, true));
	}
}
