package notes.view;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class NoteDialog extends JDialog{

	
	private static final long serialVersionUID = -4421697954488748303L;
	private static NoteDialog INSTANCE;
	private JPanel panelNoteData;
	private JLabel lblDate;
	private JTextField textField;
	private JLabel lblDescription;
	private JScrollPane scrollPaneDescription;
	private JTextArea textAreaDescription;
	private JPanel panelButtons;
	private JButton btnApply;
	private JButton btnNewButton;
	
	private NoteDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_panelNoteData = new GridBagConstraints();
		gbc_panelNoteData.insets = new Insets(10, 5, 10, 0);
		gbc_panelNoteData.fill = GridBagConstraints.BOTH;
		gbc_panelNoteData.gridx = 0;
		gbc_panelNoteData.gridy = 0;
		getContentPane().add(getPanelNoteData(), gbc_panelNoteData);
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 1;
		getContentPane().add(getPanelButtons(), gbc_panelButtons);
		
		setResizable(false);
		pack();
		
	}
	
	public static NoteDialog getInstance() {
		if(NoteDialog.INSTANCE == null) {
			NoteDialog.INSTANCE = new NoteDialog();
		}
		return NoteDialog.INSTANCE;
	}
	public JPanel getPanelNoteData() {
		if (panelNoteData == null) {
			panelNoteData = new JPanel();
			GridBagLayout gbl_panelNoteData = new GridBagLayout();
			gbl_panelNoteData.columnWidths = new int[]{0, 0, 50, 0};
			gbl_panelNoteData.rowHeights = new int[]{0, 0, 0};
			gbl_panelNoteData.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelNoteData.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panelNoteData.setLayout(gbl_panelNoteData);
			GridBagConstraints gbc_lblDate = new GridBagConstraints();
			gbc_lblDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDate.anchor = GridBagConstraints.EAST;
			gbc_lblDate.gridx = 0;
			gbc_lblDate.gridy = 0;
			panelNoteData.add(getLblDate(), gbc_lblDate);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panelNoteData.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.anchor = GridBagConstraints.EAST;
			gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescription.gridx = 0;
			gbc_lblDescription.gridy = 1;
			panelNoteData.add(getLblDescription(), gbc_lblDescription);
			GridBagConstraints gbc_scrollPaneDescription = new GridBagConstraints();
			gbc_scrollPaneDescription.gridwidth = 2;
			gbc_scrollPaneDescription.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPaneDescription.fill = GridBagConstraints.BOTH;
			gbc_scrollPaneDescription.gridx = 1;
			gbc_scrollPaneDescription.gridy = 1;
			panelNoteData.add(getScrollPaneDescription(), gbc_scrollPaneDescription);
		}
		return panelNoteData;
	}
	public JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date : ");
		}
		return lblDate;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description :");
		}
		return lblDescription;
	}
	public JScrollPane getScrollPaneDescription() {
		if (scrollPaneDescription == null) {
			scrollPaneDescription = new JScrollPane();
			scrollPaneDescription.setViewportView(getTextAreaDescription());
		}
		return scrollPaneDescription;
	}
	public JTextArea getTextAreaDescription() {
		if (textAreaDescription == null) {
			textAreaDescription = new JTextArea();
			textAreaDescription.setWrapStyleWord(true);
			textAreaDescription.setLineWrap(true);
			textAreaDescription.setRows(8);
		}
		return textAreaDescription;
	}
	public JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			GridBagLayout gbl_panelButtons = new GridBagLayout();
			gbl_panelButtons.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panelButtons.rowHeights = new int[]{0, 0};
			gbl_panelButtons.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panelButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelButtons.setLayout(gbl_panelButtons);
			GridBagConstraints gbc_btnApply = new GridBagConstraints();
			gbc_btnApply.insets = new Insets(0, 0, 0, 5);
			gbc_btnApply.gridx = 0;
			gbc_btnApply.gridy = 0;
			panelButtons.add(getBtnApply(), gbc_btnApply);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 0;
			panelButtons.add(getBtnNewButton(), gbc_btnNewButton);
		}
		return panelButtons;
	}
	public JButton getBtnApply() {
		if (btnApply == null) {
			btnApply = new JButton("Apply");
		}
		return btnApply;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Reset");
		}
		return btnNewButton;
	}
}
