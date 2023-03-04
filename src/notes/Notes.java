package notes;

import notes.controller.MainFrameController;
import notes.controller.NoteDialogController;

public class Notes {

	public static void main(String[] args) {
		MainFrameController.getInstance().init();
		NoteDialogController.getInstance().init();
	}
	
}
