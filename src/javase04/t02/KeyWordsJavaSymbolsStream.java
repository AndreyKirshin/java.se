package javase04.t02;

import java.io.*;
import java.util.*;

public class KeyWordsJavaSymbolsStream {
    private static final String pathToDir = ".\\src\\Resources\\javase04\\t02\\";
    private static List<String> keyWords;

    public KeyWordsJavaSymbolsStream() {
        keyWords = setKeyWordsList();
    }

    public String findAndCountKeyWords(String targetFileName) {
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(pathToDir + targetFileName)) {
            BufferedReader buf = new BufferedReader(fileReader);

            while (buf.ready()) {
                Collections.addAll(list, buf.readLine().split("\\s+"));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> map = getResultsMap(list);

        try (FileWriter fileWriter = new FileWriter("countKeyWordsSymbolsStream.txt")) {
            BufferedWriter bufWr = new BufferedWriter(fileWriter);
            bufWr.write(map.toString());
            bufWr.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.toString();
    }

    private List<String> setKeyWordsList() {
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(pathToDir + "keyWords.txt")) {
            BufferedReader buf = new BufferedReader(fileReader);
            while (buf.ready()) {
                list.add(buf.readLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * This method finds keyWords in the text and puts result in a map. Key is a found keyWord, value is its count in the text
     *
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
