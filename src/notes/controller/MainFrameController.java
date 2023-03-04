package notes.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import notes.model.Note;
import notes.view.MainFrame;
import notes.view.NoteDialog;

public class MainFrameController {

	
	private static MainFrameController INSTANCE;
	private boolean isInitialize;
	
	private Map<Integer, Note> noteMap = null;
	
	private MainFrameController() {
		isInitialize = false;
		noteMap = new ConcurrentHashMap<>();
	}
	
	
	private void initComponents() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					MainFrame.getInstance().getTextFieldFilter().setText("");
					DefaultTableModel model = (DefaultTableModel) MainFrame.getInstance().getTableNotes().getModel();
					model.setRowCount(0);
					
					MainFrame.getInstance().getTextField().setText("");
					MainFrame.getInstance().getTextArea().setText("");
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void initComponentsData() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void initEvents() {
		try {
			MainFrame.getInstance().getBtnAdd().addActionListener(e -> doBtnClickAddNote());
			MainFrame.getInstance().getBtnUpdate().addActionListener(e -> doBtnClickUpdateNote());
			MainFrame.getInstance().getBtnDelete().addActionListener(e -> doBtnClickRemoveNote());
			MainFrame.getInstance().getBtnFilter().addActionListener(e -> noteFilter());
			MainFrame.getInstance().getTableNotes().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					doClickTableRow();
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void doClickTableRow() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					int selectedRowIdx = MainFrame.getInstance().getTableNotes().getSelectedRow();
					if(selectedRowIdx > -1) {
						int noteId = Integer.parseInt(MainFrame.getInstance().getTableNotes().getValueAt(selectedRowIdx, 0).toString());
						Note note = noteMap.get(noteId);

						MainFrame.getInstance().getTextField().setText(note.getDate());
						MainFrame.getInstance().getTextArea().setText(note.getDescription());
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void doBtnClickAddNote() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					NoteDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance().getBtnAdd());
					NoteDialogController.getInstance().show(false, true);
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void doBtnClickUpdateNote() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					if(MainFrame.getInstance().getTableNotes().getSelectedRow() > -1) {
						NoteDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance().getBtnUpdate());
						NoteDialogController.getInstance().show(true, true);
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void doBtnClickRemoveNote() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					int selectedRowIndex = MainFrame.getInstance().getTableNotes().getSelectedRow();
					if(selectedRowIndex > -1) {
						int noteId = Integer.parseInt(MainFrame.getInstance().getTableNotes().getValueAt(selectedRowIndex, 0).toString());
						noteMap.remove(noteId);
						updateNoteTable();
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void noteFilter() {
		try {
			
			if(MainFrame.getInstance().getTextFieldFilter().getText().isEmpty()) {
				updateNoteTable();
				return;
			}
			
			DefaultTableModel tableModel = (DefaultTableModel) MainFrame.getInstance().getTableNotes().getModel();
			tableModel.setRowCount(0);
			
			String filterText = MainFrame.getInstance().getTextFieldFilter().getText();
			Pattern filterPattern = Pattern.compile(filterText);
			for(Entry<Integer, Note> note : noteMap.entrySet()) {
				Matcher filterMatcher = filterPattern.matcher(note.getValue().toString());
				if(filterMatcher.find()) {
					tableModel.addRow(new Object[] {
							note.getValue().getId(), note.getValue().getDate(), note.getValue().getDescription()
					});
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	public void updateNoteTable() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					DefaultTableModel tableModel = (DefaultTableModel) MainFrame.getInstance().getTableNotes().getModel();
					tableModel.setRowCount(0);
					for(Entry<Integer, Note> note : noteMap.entrySet()) {
						tableModel.addRow(new Object[] {
								note.getValue().getId(), note.getValue().getDate(), note.getValue().getDescription()
						});
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	public static MainFrameController getInstance() {
		if(MainFrameController.INSTANCE == null) {
			MainFrameController.INSTANCE = new MainFrameController();
		}
		return MainFrameController.INSTANCE;
	}
	
	public void init() {
		try {
			if(isInitialize) {
				System.out.println("MainFrameController already initialized ! Please check the call class ...");
				return;
			}
			
			MainFrame.getInstance().setVisible(true);
			initComponents();
			initComponentsData();
			initEvents();
			isInitialize = true;
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	public Map<Integer, Note> getNoteMap() {
		return noteMap;
	}
}
