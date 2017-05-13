package javase01.t06;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Notebook 1.0
 * Objects of this class are intended for storage of NoteInNotebook objects
 */

public class Notebook {

    /** The field array. The length of array by default is 2
     */
    private NoteInNotebook[] notesList = new NoteInNotebook[2];

    /** This method allows users to manage Notebook
     *
     */
    public void interfaceForUsers() {
       System.out.println("Welcome to the Notebook! ");
       System.out.println("=========================");

       for (int i = 0; i < 1; ) {
           System.out.println("Choose the action:");
           System.out.println("  0 - add note");
           System.out.println("  1 - remove note");
           System.out.println("  2 - edit note");
           System.out.println("  3 - show all notes");
           System.out.println("  4 - exit");
           Scanner s = new Scanner(System.in);
           String action = s.nextLine();

           if(action.equals("0")) {
               this.addNote();
           }
           else if(action.equals("1")) {
               this.removeNote();
           }
           else if(action.equals("2")) {
               this.editNote();
           }
           else if(action.equals("3")) {
               showAllNotes();
           }
           else if(action.equals("4")) {
               System.out.println("Good Bye!");
               i++;
           }
           else {
               System.out.println("Enter correct command!!!");
           }
           System.out.println("=======================");
       }
   }

    /** The method is for adding new NoteInNotebook object in the store
     */
    private void addNote() {
        for (int i = 0; i < notesList.length + 1; i++) {
            if(i == notesList.length) {
                NoteInNotebook[] newList = new NoteInNotebook[notesList.length + 1];
                System.arraycopy(notesList, 0, newList, 0, notesList.length);
                notesList = newList;
            }
            if(notesList[i] == null) {
                NoteInNotebook w = new NoteInNotebook();
                enterNewNote(w);
                notesList[i] = w;
                break;
            }
        }
    }

    /** The method is for removing a NoteInNotebook object from the store by index
     */
    private void removeNote(){
        showAllNotes();

        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Ввведите индекс удаляемой записи: ");
                Scanner s = new Scanner(System.in);

                int index = s.nextInt();

                System.arraycopy(notesList, index + 1, notesList, index, notesList.length - index - 1);
                notesList[notesList.length - 1] = null;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct index!!!");
                i--;
            }
            catch (InputMismatchException e) {
                System.out.println("Enter correct index!!!");
                i--;
            }
        }
    }

    /** The method is for editing an existing NoteInNotebook object in the store by index
     */
    private void editNote() {
        showAllNotes();

        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Ввведите индекс редактируемой записи: ");
                Scanner s = new Scanner(System.in);
                int index = s.nextInt();

                enterNewNote(notesList[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct index!!!");
                i--;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct index!!!");
                i--;
            }
        }
    }
    /** The method is for filling the field "writing" in the NoteInNotebook object from by users
     * @param w of NoteInNotebook for changing field "writing" by users
     */
    private void enterNewNote(NoteInNotebook w) {
        System.out.println("Ввведите новую запись: ");
        Scanner s = new Scanner(System.in);
        String newNote = s.nextLine();
        w.setNote(newNote);
    }

    /** The method is for printing notes contained in the Notebook
     */

    private void showAllNotes(){
        for (int i = 0; i < notesList.length; i++) {
            if(notesList[i] == null) {
                break;
            }
            else {
                System.out.println(i + " " + notesList[i].getDate() + " " + notesList[i].getNote());
            }
        }
        System.out.println();
    }
}
