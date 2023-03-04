package notes.controller;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import notes.model.Note;
import notes.view.MainFrame;
import notes.view.NoteDialog;

public class NoteDialogController {
	
	private static NoteDialogController INSTANCE;
	private boolean isInitialize = false;
	private boolean isUpdateMode = false;
	
	private int idCounter = 0;
	
	private NoteDialogController() {
		
	}
	
	private void initComponents() {
		try {
			NoteDialog.getInstance().getTextField().setText("");
			NoteDialog.getInstance().getTextAreaDescription().setText("");
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void initEvents() {
		try {
			NoteDialog.getInstance().getBtnApply().addActionListener(e -> doClickBtnApply());
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private void doClickBtnApply() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					if(checkTheFields()) {
						String date = NoteDialog.getInstance().getTextField().getText();
						String description = NoteDialog.getInstance().getTextAreaDescription().getText();
						if(isUpdateMode) {
							int selectedNoteRowIndex = MainFrame.getInstance().getTableNotes().getSelectedRow();
							int noteId = Integer.parseInt(MainFrame.getInstance().getTableNotes().getValueAt(selectedNoteRowIndex, 0).toString());
							Note note = MainFrameController.getInstance().getNoteMap().get(noteId);
							
							note.setDate(date);
							note.setDescription(description);
							JOptionPane.showMessageDialog(NoteDialog.getInstance(), "Note updated..!", "INFO", JOptionPane.INFORMATION_MESSAGE);
						} else {
							
							int noteId = idCounter;
							
							Note note = new Note();
							note.setId(noteId);
							note.setDate(date);
							note.setDescription(description);
							
							MainFrameController.getInstance().getNoteMap().put(noteId, note);
							idCounter++;
						}
						show(isUpdateMode, false);
						MainFrameController.getInstance().updateNoteTable();
					} else {
						JOptionPane.showMessageDialog(NoteDialog.getInstance(), "Invalid data", "ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	private boolean checkTheFields() {
		return (!NoteDialog.getInstance().getTextField().getText().isEmpty() && !NoteDialog.getInstance().getTextField().getText().isBlank())
				&& (!NoteDialog.getInstance().getTextAreaDescription().getText().isEmpty() && !NoteDialog.getInstance().getTextAreaDescription().getText().isBlank());
	}
	
	private void resetPanel() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					NoteDialog.getInstance().getTextField().setText("");
					NoteDialog.getInstance().getTextAreaDescription().setText("");
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	
	public static NoteDialogController getInstance() {
		if(NoteDialogController.INSTANCE == null) {
			NoteDialogController.INSTANCE = new NoteDialogController();
		}
		return NoteDialogController.INSTANCE;
	}
	
	public void init() {
		try {
			if(isInitialize) {
				System.out.println("MainFrameController already initialized ! Please check the call class ...");
				return;
			}
			
			initComponents();
			initEvents();
			isInitialize = true;
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}
	
	public void show(boolean isUpdateMode, boolean hide) {
		try {
			this.isUpdateMode = isUpdateMode;
			if(isUpdateMode) {
				NoteDialog.getInstance().setTitle("Update Note");
				NoteDialog.getInstance().getBtnApply().setText("Update");
				
				int selectedNoteRowIndex = MainFrame.getInstance().getTableNotes().getSelectedRow();
				int noteId = Integer.parseInt(MainFrame.getInstance().getTableNotes().getValueAt(selectedNoteRowIndex, 0).toString());
				Note note = MainFrameController.getInstance().getNoteMap().get(noteId);
				
				NoteDialog.getInstance().getTextField().setText(note.getDate());
				NoteDialog.getInstance().getTextAreaDescription().setText(note.getDescription());
				
			} else {
				NoteDialog.getInstance().setTitle("Add Note");
				NoteDialog.getInstance().getBtnApply().setText("Apply");
				
				resetPanel();
			}
			NoteDialog.getInstance().setVisible(hide);
		} catch (Exception e) {
			System.out.println("Exception occurred ..! " + e.getMessage());
		}
	}

}
