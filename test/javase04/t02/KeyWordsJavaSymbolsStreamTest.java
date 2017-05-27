package javase04.t02;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeyWordsJavaSymbolsStreamTest {
    @Test
    public void findAndCountKeyWords() throws Exception {
        KeyWordsJavaSymbolsStream target = new KeyWordsJavaSymbolsStream();
        assertEquals(target.findAndCountKeyWords("codeTest.txt"), "{new=7, static=1, void=1, import=6, for=3, throws=1, while=2, int=1, public=3, else=1, class=1, if=1, return=1}");
    }

}