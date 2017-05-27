package javase04.t01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class KeyWordsJava {
    private static final String pathToDir = ".\\src\\Resources\\javase04\\t01\\";
    private static List<String> keyWords;

    public KeyWordsJava() {
        try {
            keyWords = setKeyWordsList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File for reading must be in Resources
     *
     * @param targetFileName
     * @return result of searching
     */
    public String findAndCountKeyWords(String targetFileName) throws IOException {
        String fileInString = new String(Files.readAllBytes(Paths.get(pathToDir + targetFileName)));
        List<String> list = new ArrayList<>();
        Collections.addAll(list, fileInString.split("\\s+"));

        Map<String, Integer> map = getResultsMap(list);

        try(FileOutputStream fileOutputStream = new FileOutputStream("countKeyWords.txt")) {
            fileOutputStream.write(map.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map.toString();
    }

    private List<String> setKeyWordsList() throws IOException {
        String wordsInString = new String(Files.readAllBytes(Paths.get(pathToDir + "keyWords.txt")));
        List<String> list = new ArrayList<>();
        Collections.addAll(list, wordsInString.split("\\s+"));
        return list;
    }

    /**
     * This method finds keyWords in the text and puts result in a map. Key is a found keyWord, value is its count in the text
     * @param list
     * @return map
     */
    private Map<String, Integer> getResultsMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else {
                for (String keyWord : keyWords) {
                    if (s.equals(keyWord)) map.put(s, 1);
                }
            }
        }
        return map;
    }
}
