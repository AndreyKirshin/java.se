package javase04.t03;


import java.io.*;

public class ChangeUTF {
    private static final String pathToDir = ".\\src\\Resources\\javase04\\t03\\";

    public void change(){
        StringBuilder sb = new StringBuilder();
        try(FileReader fileReader = new FileReader(pathToDir + "russianText.txt")){
            BufferedReader bufRead = new BufferedReader(fileReader);

            while (bufRead.ready()){
                sb.append(bufRead.readLine() + "\n");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream("UTF16.txt")) {
            fileOutputStream.write(sb.toString().getBytes("UTF-16"));
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChangeUTF().change();
    }
}
