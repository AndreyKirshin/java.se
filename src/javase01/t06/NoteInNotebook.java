package javase01.t06;

import java.util.Date;

/** NoteInNotebook
 * The type of objects is for storage in the class Notebook
 */

public class NoteInNotebook {
    /** In this field a text of note is stored
     *
     */
    private String note;

    /** In this field the date of the note's creation is stored
     *
     */
    private Date date;

    NoteInNotebook() {
        date = new Date(System.currentTimeMillis());
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }
}
