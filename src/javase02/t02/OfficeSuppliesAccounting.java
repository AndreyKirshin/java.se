package javase02.t02;

import javase02.t03.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OfficeSuppliesAccounting {
    private List<OfficeSupplies> kit = new ArrayList<>();

    public OfficeSuppliesAccounting() {
        kit.add(new Pen(10.2f, ColorThisIsWriting.BLUE));
        kit.add(new Pen(10.4f, ColorThisIsWriting.RED));
        kit.add(new Pen(10.2f, ColorThisIsWriting.BLACK));
        kit.add(new Pencil(2.2f));
        kit.add(new Marker(5.53f, ColorThisIsWriting.ORANGE));

        print();
    }

    private void print(){
        for(int i = 0; i < kit.size(); i++) {
            System.out.println(i  + " " + kit.get(i));
        }
        System.out.println("===================");
    }

    public void interfaceForUsers() {
        System.out.println("Welcome to the OfficeSuppliesAccountingApp! ");
        System.out.println("=========================");

        for (int i = 0; i < 1; ) {
            System.out.println("Choose the action:");
            System.out.println("  0 - add thing");
            System.out.println("  1 - remove thing");
            System.out.println("  2 - show total coast");
            System.out.println("  3 - show all things");
            System.out.println("  4 - exit");
            Scanner s = new Scanner(System.in);
            String action = s.nextLine();

            if(action.equals("0")) {
                this.addThing();
            }
            else if(action.equals("1")) {
                this.print();
                this.removeThing();
            }
            else if(action.equals("2")) {
                this.getTotalCoast();
            }
            else if(action.equals("3")) {
                this.print();
            }
            else if(action.equals("4")) {
                System.out.println("Good Bye!");
                i++;
            }
            else {
                System.out.println("Enter correct command!!!");
            }
            System.out.println("=======================");
        }
    }

    private void getTotalCoast() {
        float totalCoast = 0;
        for(OfficeSupplies s : kit){
            totalCoast = totalCoast + s.getPrice();
        }
        System.out.printf("Total coast of all office supplies: %s $ \n", new DecimalFormat("#0.00").format(totalCoast));
    }

    private void removeThing() {
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Enter the index of the thing to remove");
                Scanner s = new Scanner(System.in);

                int index = s.nextInt();
                kit.remove(index);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Enter correct index!!!");
                i--;
            }
            catch (InputMismatchException e) {
                System.out.println("Enter correct index!!!");
                i--;
            }
        }
    }

    private void addThing() {
        for (int i = 0; i < 1; i++) {
            System.out.printf("Choose the thing you want to add: \n " +
                "1 - pen \n" +
                "2 - pencil \n" +
                "3 - marker \n" +
                "4 - corrector \n" +
                "5 - note \n" +
                "6 - paper \n" +
                "7 - puncher \n" +
                "8 - stapler \n" +
                "9 - stickers \n" +
                "10 - clips \n" +
                "11 - other \n");
            Scanner s = new Scanner(System.in);
            String thing = s.nextLine();

            switch (thing) {
                case "1": kit.add(new Pen(receivePrice(), chooseColor()));
                    break;
                case "2": kit.add(new Pencil(receivePrice()));
                    break;
                case "3": kit.add(new Marker(receivePrice(), chooseColor()));
                    break;
                case "4": kit.add(new Corrector(receivePrice()));
                    break;
                case "5": kit.add(new Note(receivePrice()));
                    break;
                case "6": kit.add(new Paper(receivePrice()));
                    break;
                case "7": kit.add(new Puncher(receivePrice()));
                    break;
                case "8": kit.add(new Stapler(receivePrice()));
                    break;
                case "9": kit.add(new Sticers(receivePrice()));
                    break;
                case "10": kit.add(new Clips(receivePrice()));
                    break;
                case "11": kit.add(new UnknownSupplies(receivePrice(), enterNewThingName()));
                    break;
                default:{
                    System.out.println("Choose correct number!!!");
                    i--;
                    break;
                }
            }
        }
    }
    
    private ColorThisIsWriting chooseColor() {
        ColorThisIsWriting chosenColor = ColorThisIsWriting.BLUE;
        for (int i = 0; i < 1; i++) {
            System.out.printf("0- BLUE,\n" +
                    "    1- RED,\n" +
                    "    2- BLACK,\n" +
                    "    3- ORANGE,\n" +
                    "    4- GREEN,\n" +
                    "    5- YELLOW,\n" +
                    "    6- PINK \n");
            Scanner s = new Scanner(System.in);
            String color = s.nextLine();

            switch (color){
                case "0": chosenColor = ColorThisIsWriting.BLUE;
                    break;
                case "1": chosenColor = ColorThisIsWriting.RED;
                    break;
                case "2": chosenColor = ColorThisIsWriting.BLACK;
                    break;
                case "3": chosenColor = ColorThisIsWriting.ORANGE;
                    break;
                case "4": chosenColor = ColorThisIsWriting.GREEN;
                    break;
                case "5": chosenColor = ColorThisIsWriting.YELLOW;
                    break;
                case "6": chosenColor = ColorThisIsWriting.PINK;
                    break;
                default: {
                    System.out.println("Choose correct number!!!");
                    i--;
                }
            }
        }
        return chosenColor;
    }

    private float receivePrice() {
        float price = 0;
        for (int i = 0; i < 1; i++) {
            try{
                System.out.println("Enter price of the new thing: ");
                Scanner s = new Scanner(System.in);
                price = s.nextFloat();
            }catch (InputMismatchException e) {
                System.out.println("Enter correct price!!!");
                i--;
            }
        }
        return price;
    }

    private String enterNewThingName() {
        System.out.println("Enter name of the new thing: ");
        String newThing = "new thing";
        for (int j = 0; j < 1; j++) {
            Scanner s = new Scanner(System.in);
            newThing = s.nextLine();
            if(null == newThing) {
                System.out.println("Enter correct name!!!");
                j--;
            }
        }
        return newThing;
    }
    public static void main(String[] args) {
        new OfficeSuppliesAccounting().interfaceForUsers();
    }
}
