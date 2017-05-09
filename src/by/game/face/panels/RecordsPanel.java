package by.game.face.panels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import by.game.face.Constants;

public class RecordsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static RecordsPanel recordsPanel;

	public RecordsPanel() {
		setBounds(80, 135, 380, 435);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		setVisible(true);
		recordsPanel = this;

		initLabels();
		showRecords();
	}

	private void initLabels() {

		JLabel label;
		int height = 20;

		for (int i = 0; i < Constants.listOfRecords.size(); i++) {
			label = new JLabel();
			label.setBounds(12, height, 350, 30);
			// label.setBorder(BorderFactory.createSoftBevelBorder(0));
			add(label);
			Constants.listOfRecordsTableLabels.add(label);
			height += 40;
		}

	}

	public void showRecords() {
		StringBuilder builder;
		for (int i = 0; i < Constants.listOfRecordsTableLabels.size(); i++) {
			builder = new StringBuilder();
			builder.append("<html><pre><font size=6 ");
			if (i == 0) {
				builder.append(" color='red' ");
			}
			builder.append("face='Courier New'> " + (i + 1) + ". ");
			if (i > 8) {
				builder.deleteCharAt(builder.length() - 1);
			}
			builder.append(Constants.listOfRecords.get(i).getName() + " ");
			for (int j = 15 - Constants.listOfRecords.get(i).getName().length(); j > 0; j--) {
				builder.append(".");
			}
			builder.append(" " + Constants.listOfRecords.get(i).getScore());

			Constants.listOfRecordsTableLabels.get(i).setText(builder.toString());
		}

	}

	public static void hidePanel() {
		if (recordsPanel != null) {
			recordsPanel.setVisible(false);
		}
	}

	public static void showPanel() {
		if (recordsPanel != null) {
			recordsPanel.setVisible(true);
			recordsPanel.showRecords();
		}
	}

}
