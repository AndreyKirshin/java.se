package javase03.t03;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the second version of task03. It allows to find references to pictures and returns all sentences with references
 * Also it answers the question about the order of picture's numbers in references
 * This code is better then before but still not perfect)
 */
public class ReferenceToPictures {
    private String regEx = "[А-Я][^\\.?]*([Рр]ис)((.){1,4})\\s(\\d+)[^\\.]{0,}[\\.\\?\\!]";

    public void printReferences() {
        System.out.println("List of references to pictures in the text:");
        for (String s : getReferences(getMatcher(getTextAsStringBuilder()))) {
            System.out.println(s);
        }
        System.out.println("Does the author refer to pictures in order? - " + isOrder(getMatcher(getTextAsStringBuilder())));
    }
    private StringBuilder getTextAsStringBuilder() {
        Class<ReferenceToPictures> cl = ReferenceToPictures.class;
        InputStreamReader isr = new InputStreamReader(cl
                .getResourceAsStream("Java.SE.03.html"));

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(isr)) {
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }
    private Matcher getMatcher(StringBuilder sb) {
        Pattern regExPattern = Pattern.compile(regEx);
        return regExPattern.matcher(sb);
    }

    private List<String> getReferences(Matcher matcher) {
        List<String> references = new ArrayList<>();
        while (matcher.find()) {
            references.add(matcher.group());
        }
        return references;
    }

    /**
     * This method returns true if the author refers to pictures in order
     * @param matcher
     * @return boolean
     */
    private boolean isOrder(Matcher matcher) {
        List<Integer> numbers = new ArrayList<>();
        int i = 0;
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group(4)));

            if(i > 0 && numbers.get(i) < numbers.get(i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        new ReferenceToPictures().printReferences();
    }
}
