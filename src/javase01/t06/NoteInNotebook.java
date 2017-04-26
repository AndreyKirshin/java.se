package javase01.t06;

import java.util.Date;

/** WritingInNotebook
 * The type of objects is for storage in the class Notebook
 */

public class WritingInNotebook {
    private String writing;
    private Date date;

    WritingInNotebook() {
        date = new Date(System.currentTimeMillis());
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public Date getDate() {
        return date;
    }
}
