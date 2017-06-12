package javase06.t02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesReaderMap {
    Map<String, String> propertiesMap;

    public PropertiesReaderMap(String fileName) {
        propertiesMap = loadProperties(fileName);
        if(propertiesMap == null) {
            System.out.println("Failed to read file with properties");
        }
    }

    protected Map<String, String> loadProperties(String fileName){
        Pattern p = Pattern.compile(".+\\.properties$");
        Matcher m = p.matcher(fileName);
        if(!m.matches()) {
            System.out.println("File's name is not correct");
            return null;
        }
        Map<String, String> map = new HashMap<>();
        try(FileReader fr = new FileReader(fileName)){
            BufferedReader buf = new BufferedReader(fr);
            String line;
            while ((line = buf.readLine()) != null){
                if(line.contains("=")){
                    String[] pair = line.split("=");
                    map.put(pair[0], pair[1]);
                }
            }
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getPropertiesMap() {
        return propertiesMap;
    }

    public String getProperty(String key){
        return propertiesMap.get(key);
    }
}
