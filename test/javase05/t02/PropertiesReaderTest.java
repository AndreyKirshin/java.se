package javase05.t02;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class PropertiesReaderTest {

    @Test
    public void getValueFromPropTest() throws Exception {
        PropertiesReader target = new PropertiesReader(".\\src\\Resources\\javase05\\t02\\Test.properties");
        assertEquals("v3", target.getValueFromProp("k3"));
    }

    @Test
    public void NoKeyExceptionTest() throws Exception {
        try{
            PropertiesReader target = new PropertiesReader(".\\src\\Resources\\javase05\\t02\\Test.properties");
            System.out.println(target.getValueFromProp("fgd"));
        } catch (NoKeyException e){

        }

    }
}