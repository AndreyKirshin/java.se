package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionsAndAnswersService {

    public void runUsersInterface() {
        System.out.println("Hallo! Select language (ru - 1 / en - 2)");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        Locale lang = selectLanguage(selection);

        ResourceBundle rb = ResourceBundle.getBundle("QABundle", lang);
        printQuestions(rb);

        for (int i = 0; i < 1; ) {
            System.out.println("Please, select question's number");

            scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            System.out.println("Answer: " + getAnswer(rb, selection));
            System.out.println();
            System.out.println("Again? (1 - yes / 2 - no)");
            scanner = new Scanner(System.in);
            selection = scanner.nextInt();
            if(selection != 1) i++;
        }
    }

    private Locale selectLanguage(int selection) {
        return selection == 1 ? Locale.forLanguageTag("ru") : Locale.forLanguageTag("en");
    }

    private String getAnswer(ResourceBundle rb, int selection) {
        if (selection > rb.keySet().size()) {
            System.out.println("Select correct number!!!");
            Scanner s = new Scanner(System.in);
            selection = s.nextInt();
            getAnswer(rb, selection);
        }
        return rb.getString("a" + selection);
    }

    private void printQuestions(ResourceBundle rb){
        for (int i = 1; i <= rb.keySet().size()/2; i++) {
            System.out.println(i +" " + rb.getString("q" + i));
        }
    }

    public static void main(String[] args) {
        new QuestionsAndAnswersService().runUsersInterface();
    }
}
