package javase05.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties prop;

    public PropertiesReader(String path) {
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
            fileInputStream.close();
            prop = properties;
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            e.printStackTrace();
            prop = new Properties();
        } catch (IOException e) {
            System.out.println("To load properties from this file is impossible");
            e.printStackTrace();
            prop = new Properties();
        }
    }

    public Properties getProp() {
        return prop;
    }

    public String getValueFromProp(String key) {
        if (prop.containsKey(key)) {
            return getProp().getProperty(key);
        } else {
            NoKeyException e = new NoKeyException();
            e.printStackTrace();
            System.out.println("There is not this key here");
            return "";
        }
    }

    public static void main(String[] args) {
        PropertiesReader target = new PropertiesReader(".\\src\\Resources\\javase05\\t02\\Test.properties");
        System.out.println(target.getValueFromProp("fgd"));
    }

}
class NoKeyException extends RuntimeException {
}