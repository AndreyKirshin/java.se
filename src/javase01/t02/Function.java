package javase01.t02;

/**
 * Created by 1 on 23.04.2017.
 */
public class Function {

    public void showResult(){

        int i = 1;
        double epsilon = 1e-2;

        while (true) {

            double a = 1/Math.sqrt(i + 1);

            if (a < epsilon) {
                System.out.println();
                System.out.println("Искомый номер: " + i);
                break;
            }
            else System.out.print(a + ", ");
            i++;
        }
    }
}
