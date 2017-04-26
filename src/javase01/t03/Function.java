package javase01.t02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 1 on 23.04.2017.
 */
public class Function {

    ArrayList<Double> arguments = argumentsList(3.14, 6.38, 0.01);



    public void showResult(){

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


