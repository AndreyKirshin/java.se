package javase05.t01;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by 1 on 04.06.2017.
 */
public class TextFilesWorkerTest {


    @Test
    public void loadTextFromFile() throws Exception {
        FileViewer viewer = new FileViewer();
        viewer.changeDir(".\\TestDirForFileViewer");
        FileViewer.TextFilesWorker worker = viewer.new TextFilesWorker();

        System.out.println(worker.loadTextFromFile("ssss.txt"));
        System.out.println(worker.getText());
    }

    @Test
    public void writeToFileTest() throws Exception {
        FileViewer viewer = new FileViewer();
        viewer.changeDir(".\\TestDirForFileViewer");
        FileViewer.TextFilesWorker worker = viewer.new TextFilesWorker();
        worker.loadTextFromFile("ssss.txt");

        System.out.println(worker.writeToFile("It's unbelievable!"));

    }
}