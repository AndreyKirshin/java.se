package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionsAndAnswersService {

    public void runUsersInterface() {
        System.out.println("Hallo! Select language (ru - 1 / en - 2)");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        Locale lang = selection == 1 ? Locale.forLanguageTag("ru") : Locale.forLanguageTag("en");

        ResourceBundle rb = ResourceBundle.getBundle("QABundle", lang);
        System.out.println("1 " + rb.getString("q1"));
        System.out.println();
        System.out.println("2 " + rb.getString("q2"));
        System.out.println();
        System.out.println("3 " + rb.getString("q3"));
        System.out.println();
        System.out.println("4 " + rb.getString("q4"));
        System.out.println();

        for (int i = 0; i < 1; ) {
            System.out.println("Please, select question's number");

            scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            System.out.println("Answer: " + rb.getString("a" + selection));
            System.out.println();
            System.out.println("Again? (1 - yes / 2 - no)");
            scanner = new Scanner(System.in);
            selection = scanner.nextInt();
            if(selection != 1) i++;
        }
    }

    public static void main(String[] args) {
        new QuestionsAndAnswersService().runUsersInterface();
    }
}
