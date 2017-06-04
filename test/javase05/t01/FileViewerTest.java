package javase05.t01;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by 1 on 03.06.2017.
 */
public class FileViewerTest {
    FileViewer target = new FileViewer();

    @Test
    public void getCurrentDirTest() throws Exception {
        System.out.println(target.getCurrentDir());
        assertEquals(target.getCurrentDir(), "C:\\");
    }

    @Test
    public void loadFileListTest() throws Exception {
        System.out.println(target.loadFileList(Paths.get(".\\src\\javase01")));
       assertEquals(target.loadFileList(Paths.get(".\\src\\javase01")).toString(), "[t01, t02, t03, t04, t05, t06]");

    }

    @Test
    public void changeDirTest() throws Exception {
        target.changeDir(".\\src\\javase01");
        assertEquals(target.getCurrentDir(), ".\\src\\javase01");
        assertEquals(target.getCurrentFileList().toString(), "[t01, t02, t03, t04, t05, t06]");
    }

    @Test
    public void goUpLevelTest() throws Exception {

        target.changeDir(".\\src\\javase01\\t01");
        System.out.println(target.getCurrentDir());
        System.out.println(target.getCurrentFileList());
        assertEquals(target.goUpLevel(), ".\\src\\javase01");
    }

    @Test
    public void createTextFileTest() throws Exception {
        target.changeDir(".\\TestDirForFileViewer");
        System.out.println(target.getCurrentDir());
        System.out.println(target.getCurrentFileList());

        assertEquals(target.createTextFile("ssss"), "");
        System.out.println(target.getCurrentDir());
        System.out.println(target.getCurrentFileList());

    }

    @Test
    public void deleteFileTest() throws Exception {
        target.changeDir(".\\TestDirForFileViewer");
        target.createTextFile("ddd");
        System.out.println(target.getCurrentFileList());

        target.deleteFile("ddd.txt");
        System.out.println(target.getCurrentFileList());
    }
}