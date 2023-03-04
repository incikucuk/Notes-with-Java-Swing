package notes.view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	

	private static final long serialVersionUID = -4404244642678152695L;
	private static MainFrame INSTANCE;
	private JPanel panelFilter;
	private JTextField textFieldFilter;
	private JButton btnFilter;
	private JPanel panelTable;
	private JScrollPane scrollPaneTable;
	private JTable tableNotes;
	private JPanel panelButtons;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JPanel panelDetails;
	private JLabel lblDate;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	
	private MainFrame() {
		
		setTitle("inci kucuk | note app");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_panelFilter = new GridBagConstraints();
		gbc_panelFilter.insets = new Insets(10, 5, 10, 0);
		gbc_panelFilter.fill = GridBagConstraints.BOTH;
		gbc_panelFilter.gridx = 0;
		gbc_panelFilter.gridy = 0;
		getContentPane().add(getPanelFilter(), gbc_panelFilter);
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.insets = new Insets(0, 5, 5, 5);
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 0;
		gbc_panelTable.gridy = 1;
		getContentPane().add(getPanelTable(), gbc_panelTable);
		GridBagConstraints gbc_panelDetails = new GridBagConstraints();
		gbc_panelDetails.insets = new Insets(0, 5, 10, 5);
		gbc_panelDetails.fill = GridBagConstraints.BOTH;
		gbc_panelDetails.gridx = 0;
		gbc_panelDetails.gridy = 2;
		getContentPane().add(getPanelDetails(), gbc_panelDetails);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public  static MainFrame getInstance() {
		if(MainFrame.INSTANCE == null) {
			MainFrame.INSTANCE = new MainFrame();
		}
		return MainFrame.INSTANCE;
	}
	public JPanel getPanelFilter() {
		if (panelFilter == null) {
			panelFilter = new JPanel();
			GridBagLayout gbl_panelFilter = new GridBagLayout();
			gbl_panelFilter.columnWidths = new int[]{0, 0, 0};
			gbl_panelFilter.rowHeights = new int[]{0, 0};
			gbl_panelFilter.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_panelFilter.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelFilter.setLayout(gbl_panelFilter);
			GridBagConstraints gbc_textFieldFilter = new GridBagConstraints();
			gbc_textFieldFilter.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldFilter.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldFilter.gridx = 0;
			gbc_textFieldFilter.gridy = 0;
			panelFilter.add(getTextFieldFilter(), gbc_textFieldFilter);
			GridBagConstraints gbc_btnFilter = new GridBagConstraints();
			gbc_btnFilter.gridx = 1;
			gbc_btnFilter.gridy = 0;
			panelFilter.add(getBtnFilter(), gbc_btnFilter);
		}
		return panelFilter;
	}
	public JTextField getTextFieldFilter() {
		if (textFieldFilter == null) {
			textFieldFilter = new JTextField();
			textFieldFilter.setColumns(10);
		}
		return textFieldFilter;
	}
	public JButton getBtnFilter() {
		if (btnFilter == null) {
			btnFilter = new JButton("Filter");
		}
		return btnFilter;
	}
	public JPanel getPanelTable() {
		if (panelTable == null) {
			panelTable = new JPanel();
			GridBagLayout gbl_panelTable = new GridBagLayout();
			gbl_panelTable.columnWidths = new int[]{0, 0, 0};
			gbl_panelTable.rowHeights = new int[]{0, 0};
			gbl_panelTable.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_panelTable.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panelTable.setLayout(gbl_panelTable);
			GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
			gbc_scrollPaneTable.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
			gbc_scrollPaneTable.gridx = 0;
			gbc_scrollPaneTable.gridy = 0;
			panelTable.add(getScrollPaneTable(), gbc_scrollPaneTable);
			GridBagConstraints gbc_panelButtons = new GridBagConstraints();
			gbc_panelButtons.fill = GridBagConstraints.BOTH;
			gbc_panelButtons.gridx = 1;
			gbc_panelButtons.gridy = 0;
			panelTable.add(getPanelButtons(), gbc_panelButtons);
		}
		return panelTable;
	}
	
	public JScrollPane getScrollPaneTable() {
		if (scrollPaneTable == null) {
			scrollPaneTable = new JScrollPane();
			scrollPaneTable.setViewportView(getTableNotes());
		}
		return scrollPaneTable;
	}
	
	public JTable getTableNotes() {
		if (tableNotes == null) {
			tableNotes = new JTable();
			DefaultTableModel tableModel = new DefaultTableModel(0, 0) {
				
				private static final long serialVersionUID = 371714546404725607L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			tableNotes.setModel(tableModel);
			
			tableModel.addColumn("ID");
			tableModel.addColumn("Date");
			tableModel.addColumn("Content");
			
			tableNotes.getColumnModel().getColumn(0).setMinWidth(55);
			tableNotes.getColumnModel().getColumn(0).setMaxWidth(55);
			
			tableNotes.getColumnModel().getColumn(1).setMinWidth(170);
			tableNotes.getColumnModel().getColumn(1).setMaxWidth(170);
			
			
		}
		return tableNotes;
	}
	public JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			GridBagLayout gbl_panelButtons = new GridBagLayout();
			gbl_panelButtons.columnWidths = new int[]{0, 0};
			gbl_panelButtons.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelButtons.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panelButtons.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelButtons.setLayout(gbl_panelButtons);
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
			gbc_btnAdd.gridx = 0;
			gbc_btnAdd.gridy = 0;
			panelButtons.add(getBtnAdd(), gbc_btnAdd);
			GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
			gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
			gbc_btnUpdate.gridx = 0;
			gbc_btnUpdate.gridy = 1;
			panelButtons.add(getBtnUpdate(), gbc_btnUpdate);
			GridBagConstraints gbc_btnDelete = new GridBagConstraints();
			gbc_btnDelete.gridx = 0;
			gbc_btnDelete.gridy = 2;
			panelButtons.add(getBtnDelete(), gbc_btnDelete);
		}
		return panelButtons;
	}
	public JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton();
			btnAdd.setIcon(new ImageIcon("C:\\Users\\inci.kucuk\\Downloads\\plus.png"));
		}
		return btnAdd;
	}
	public JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setIcon(new ImageIcon("C:\\Users\\inci.kucuk\\Downloads\\update.png"));
		}
		return btnUpdate;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setIcon(new ImageIcon("C:\\Users\\inci.kucuk\\Downloads\\delete.png"));
		}
		return btnDelete;
	}
	public JPanel getPanelDetails() {
		if (panelDetails == null) {
			panelDetails = new JPanel();
			panelDetails.setBorder(new TitledBorder(null, "Note Detail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagLayout gbl_panelDetails = new GridBagLayout();
			gbl_panelDetails.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panelDetails.rowHeights = new int[]{0, 0, 0};
			gbl_panelDetails.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelDetails.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			panelDetails.setLayout(gbl_panelDetails);
			GridBagConstraints gbc_lblDate = new GridBagConstraints();
			gbc_lblDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDate.anchor = GridBagConstraints.EAST;
			gbc_lblDate.gridx = 0;
			gbc_lblDate.gridy = 0;
			panelDetails.add(getLblDate(), gbc_lblDate);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panelDetails.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			panelDetails.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.gridwidth = 2;
			gbc_textArea.insets = new Insets(0, 0, 0, 5);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 1;
			gbc_textArea.gridy = 1;
			panelDetails.add(getTextArea(), gbc_textArea);
		}
		return panelDetails;
	}
	public JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date :");
		}
		return lblDate;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setEditable(false);
		}
		return textField;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Description : ");
		}
		return lblNewLabel;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setRows(6);
			textArea.setEditable(false);
		}
		return textArea;
	}
}
