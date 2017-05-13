package javase01.t03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Function {


    Function() {
        System.out.println("Введите а: ");
        Scanner s = new Scanner(System.in);
        double a = s.nextDouble();

        System.out.println("Введите b: ");
        double b = s.nextDouble();

        System.out.println("Введите h: ");
        double h = s.nextDouble();

        ArrayList<Double> arguments = argumentsList(a, b, h);
        showResult(arguments);
    }



    public void showResult(ArrayList<Double> arguments){

        for(int i = 0; i < arguments.size(); i++) {
            double [] argAndValue = new double[2];
            double arg = arguments.get(i);
            argAndValue[0] = arg;

            double value = Math.tan(arg * 2) - 3;
            argAndValue[1] = value;

            System.out.println(Arrays.toString(argAndValue));
            System.out.println();
        }
    }

    private ArrayList<Double> argumentsList (double a, double b, double h) {
        ArrayList<Double> arguments = new ArrayList<>();

        while (a <= b) {
            arguments.add(a);
            a = a + h;
        }
        return arguments;
    }
}


