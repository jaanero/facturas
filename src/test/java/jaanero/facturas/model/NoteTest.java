package jaanero.facturas.model;

import org.junit.Assert;
import org.junit.Test;

public class NoteTest {

	public static final Long NOTE_ID = Long.valueOf(1);
	public static final String NOTE_NAME = "Cursos sin IVA";
	public static final String NOTE_TEXT = "Description of the reason why some taxes are applied";

	public static final String ANOTHER_NOTE_NAME = "Cursos con IVA reducido";
	public static final String ANOTHER_NOTE_TEXT = "Artículo de la ley por la que se puede poner IVA reducido";

	public static Note NOTE = new Note(NOTE_NAME,NOTE_TEXT);

	@Test
	public void should_create_a_note_and_populate_it(){
		final Note note = new Note(NOTE_NAME,NOTE_TEXT);
		Assert.assertEquals(note.getName(), NOTE_NAME);
		Assert.assertEquals(note.getText(), NOTE_TEXT);
	}

	@Test
	public void should_be_able_to_modify_note(){
		final Note note = new Note(NOTE_NAME,NOTE_TEXT);

		note.setId(NOTE_ID);
		note.setName(ANOTHER_NOTE_NAME);
		note.setText(ANOTHER_NOTE_TEXT);

		Assert.assertEquals(note.getId(), NOTE_ID);
		Assert.assertEquals(note.getName(), ANOTHER_NOTE_NAME);
		Assert.assertEquals(note.getText(), ANOTHER_NOTE_TEXT);
	}
}
