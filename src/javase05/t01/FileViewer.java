package javase05.t01;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileViewer {

    private String currentDirectory;
    private List<String> currentFileList;

    public FileViewer(){
        currentDirectory = Paths.get(File.listRoots()[0].getAbsolutePath()).toString();
        currentFileList = loadFileList(Paths.get(File.listRoots()[0].getAbsolutePath()));
    }


    public void runUserInterface(){
        System.out.println("Hello! Welcome to File Viewer");
        printInformation();
        System.out.println();
        System.out.println();
        while (true) {
            System.out.println("What do you want? \n"
                    + "1 - go up level\n"
                    + "2 - change directory\n"
                    + "3 - create txt file\n"
                    + "4 - delete file\n"
                    + "5 - add text to txt file\n"
                    + "6 - view text to txt file\n"
                    + "7 - exit\n");
            int command;
            while (true) {
                Scanner s = new Scanner(System.in);
                if(s.hasNextInt()){
                    command = s.nextInt();
                    if(command>0 & command<8) break;
                    else System.out.println("Enter correct command");
                }
                else System.out.println("Enter correct command");
            }
            if(command == 1) {
                goUpLevel();
                printInformation();
            }
            if(command == 2){
                System.out.println("Enter full path to the directory");
                while (true){
                    Scanner s = new Scanner(System.in);
                    String enter = s.nextLine();
                    if(enter.equals("#")) break;
                    String newDirPath = changeDir(enter);
                    if(newDirPath.equals("")){
                        System.out.println("Enter correct path!");
                    }
                    else {
                        printInformation();
                        break;
                    }
                }
            }
            if(command == 3){
                System.out.println("Enter name of new file");
                while (true){
                    Scanner s = new Scanner(System.in);
                    String enter = s.nextLine();
                    if(enter.equals("#")) break;
                    String newFile = createTextFile(enter);
                    if(newFile.equals("")){
                        System.out.println("Try again");
                    } else {
                        printInformation();
                        break;
                    }
                }
            }
            if(command == 4){
                System.out.println("Enter name of file to delete");
                while (true){
                    Scanner s = new Scanner(System.in);
                    String enter = s.nextLine();
                    if(enter.equals("#")) break;
                    if (!deleteFile(enter)){
                        System.out.println("Try again");
                    } else {
                        printInformation();
                        break;
                    }
                }
            }
            if(command == 5) {
                FileViewer.TextFilesWorker worker = this.new TextFilesWorker();
                System.out.println("Enter file name");
                while (true){
                    Scanner s = new Scanner(System.in);
                    String enter = s.nextLine();
                    if(enter.equals("#")) break;
                    String textFromFile = worker.loadTextFromFile(enter);
                    if(textFromFile.equals("")){
                        System.out.println("Try again");
                    } else {
                        System.out.println(textFromFile);
                        System.out.println();
                        System.out.println("Enter text to addition");
                        s = new Scanner(System.in);
                        worker.writeToFile(s.nextLine());
                        System.out.println("Done!");
                        break;
                    }
                }
            }

            if(command == 6){
                FileViewer.TextFilesWorker worker = this.new TextFilesWorker();
                System.out.println("Enter file name");
                while (true) {
                    Scanner s = new Scanner(System.in);
                    String enter = s.nextLine();
                    if(enter.equals("#")) break;
                    String textFromFile = worker.loadTextFromFile(enter);
                    if (textFromFile.equals("")) {
                        System.out.println("Try again");
                    } else {
                        System.out.println(textFromFile);
                        System.out.println();
                        break;
                    }
                }
            }
            if(command == 7){
                System.out.println("Good bye!");
                break;
            }
        }
    }

    private void printInformation(){
        System.out.println("You are hear: " + currentDirectory);
        System.out.println("There are folowing files & directories here:");
        for (String s : currentFileList){
            System.out.println("  " + s);
        }
        System.out.println("======================");
    }

    protected List<String> getCurrentFileList() {
        return currentFileList;
    }

    public String getCurrentDir() {
        return currentDirectory;
    }

    public List<String> loadFileList(Path path) {
        return Arrays.asList(path.toFile().list());
    }

    protected String goUpLevel() {
        Path parentPath = Paths.get(currentDirectory).getParent();
        if (parentPath == null) {
            System.out.println("This is a root directory!!!");
            return currentDirectory;
        }
        currentDirectory = parentPath.toString();
        currentFileList = loadFileList(parentPath);
        return parentPath.toString();
    }

    protected String changeDir(String stringPath){
        File newDir = new File(stringPath);
        if(!newDir.exists()){
            System.out.println("Directory is not exist!");
            return "";
        }
        if(!newDir.isDirectory()){
            System.out.println("It is not directory!");
            return "";
        }
        currentFileList = loadFileList(newDir.toPath());
        return currentDirectory = stringPath;
    }
    protected String createTextFile(String name) {
        name = name + ".txt";
        if(currentFileList.contains(name)) {
            System.out.println("File having this name is already exist. Tty again");
            return "";
        }
        name = currentDirectory + "\\" + name;
        try {
            Files.createFile(Paths.get(name));
            currentFileList = loadFileList(Paths.get(currentDirectory));
            return name;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something is wrong. Tty again");
            return "";
        }
    }

    protected boolean deleteFile(String name){
        try {
            Files.delete(Paths.get(currentDirectory + "\\" + name));
            currentFileList = loadFileList(Paths.get(currentDirectory));
            return true;
        } catch (NoSuchFileException e){
            System.out.println("Fail not found");
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            System.out.println("Something is wrong. Tty again");
            e.printStackTrace();
            return false;
        }
    }

    class TextFilesWorker {
        private String fileName;
        private String text;

        public String getText() {
            return text;
        }

        protected String loadTextFromFile(String fileName) {
            if (!currentFileList.contains(fileName)) {
                System.out.println("File not found. Maybe you have forgotten .txt?");
                return "";
            }else{
                this.fileName = currentDirectory + "\\" + fileName;
            }
            try {
                String s = new String(Files.readAllBytes(Paths.get(this.fileName))) + "\n";
                text = s;
                return s;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "";
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        protected String writeToFile(String addition){
            String newText = text + "\n" + addition;
            try(FileOutputStream fos = new FileOutputStream(fileName)) {
                BufferedOutputStream buf = new BufferedOutputStream(fos);
                buf.write(newText.getBytes("UTF-8"));
                buf.flush();
                fos.close();
                return newText;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return text;
            } catch (IOException e) {
                e.printStackTrace();
                return text;
            }
        }
    }
}
