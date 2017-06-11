package javase06.t02;

import org.junit.Test;

import static org.junit.Assert.*;


public class PropertiesReaderMapTest {
    @Test
    public void loadPropertiesTest() throws Exception {
        PropertiesReaderMap target = new PropertiesReaderMap(".\\src\\Resources\\javase06\\t02\\File.properties");
        System.out.println(target.getPropertiesMap());
        assertEquals(target.getPropertiesMap().size(), 5);
        assertEquals(target.getProperty("homeland"), "USSR");

        PropertiesReaderMap target2 = new PropertiesReaderMap("ghfhdfghfd");
        assertEquals(target2.getPropertiesMap(), null);
    }

}