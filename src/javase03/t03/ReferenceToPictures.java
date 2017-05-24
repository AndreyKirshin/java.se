package javase03.t03;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the first version of task03. It allows to find references like "рис. 1".
 * Also it answers the question about the order of picture's numbers in references
 * I will complete this task later
 */
public class ReferenceToPictures {
    private String regEx = "([Рр]ис.)\\s(\\d+)";

    public void printReferences(){
        System.out.println("List of references to pictures in the text: " + getReferences(getMatcher(getTextAsStringBuilder())));
        System.out.println("Does the author refer to pictures in order? - " + isOrder(getNumbersOfPictures(getMatcher(getTextAsStringBuilder()))));
    }

    private StringBuilder getTextAsStringBuilder() {
        Class<ReferenceToPictures> cl = ReferenceToPictures.class;
        InputStreamReader isr = new InputStreamReader(cl
                .getResourceAsStream("Java.SE.03.html"));

        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(isr)){
            while (br.ready()) {
                sb.append(br.readLine());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }

    private Matcher getMatcher(StringBuilder sb){
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

    private List<Integer> getNumbersOfPictures(Matcher matcher){
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()){
            numbers.add(Integer.parseInt(matcher.group(2)));
        }
        return numbers;
    }

    private boolean isOrder(List<Integer> list){
        boolean result = true;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) result = false;
        }
        return result;
    }

    public static void main(String[] args) {
       new ReferenceToPictures().printReferences();
    }
}
