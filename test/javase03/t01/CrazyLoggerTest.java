package javase03.t01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CrazyLoggerTest {
    private CrazyLogger target = new CrazyLogger();

    @Before
    public void setUp() throws Exception {
        target.writeToLog("It's a logger, baby");
        target.writeToLog("My logger is my castle");
    }

    @Test
    public void testWriteToLog() throws Exception {

        assertTrue(target.getLog().contains("It's a logger, baby"));
        assertTrue(target.getLog().contains("My logger is my castle"));

    }


    @Test
    public void findInLog() throws Exception {
        String s = target.findInLog("logger");
        assertTrue(s.contains("It's a logger, baby"));
        assertTrue(s.contains("My logger is my castle"));
    }


}