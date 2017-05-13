package by.game.face.panels;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import by.game.face.Constants;

public class HighscoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static HighscoresPanel highscoresPanel;
	private JTextField recordNameField;

	public HighscoresPanel() {
		setBounds(80, 135, 380, 435);
		setLayout(null);
		setBorder(BorderFactory.createSoftBevelBorder(0));
		setVisible(true);
		highscoresPanel = this;

		initComponents();
		showRecords();

		add(recordNameField);

	}

	private void initComponents() {

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

		recordNameField = new JTextField();
		recordNameField.setBounds(63, 60, 140, 26);
		recordNameField.setBorder(BorderFactory.createEtchedBorder());
		recordNameField.setDocument(new PlainDocument() {
			private static final long serialVersionUID = 1L;

			@Override
			public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
				if (str == null)
					return;
				if ((getLength() + str.length()) <= 11) {
					super.insertString(offset, str, attr);
				}
			}
		});
		recordNameField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				recordNameField.setSelectionStart(0);
				recordNameField.setSelectionEnd(9);
			}

			public void focusLost(FocusEvent e) {
				recordNameField.select(0, 0);
			}
		});
		recordNameField.setFont(new Font("Courier new", Font.BOLD, 20));
		recordNameField.setText("anonymous");

		recordNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					recordNameField.setText("Got it!");

				}
			}
		});
		recordNameField.setVisible(false);

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
		if (highscoresPanel != null) {
			highscoresPanel.setVisible(false);
		}
	}

	public static void showPanel() {
		if (highscoresPanel != null) {
			highscoresPanel.setVisible(true);
			highscoresPanel.showRecords();
		}
	}

}
