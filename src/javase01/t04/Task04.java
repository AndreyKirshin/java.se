package javase01.t04;


import java.util.Arrays;

public class Task04 {

    Task04() {


        float[] a = {1,2,3,4,5,6};
        float[] b = {1,2,3,5,10};
        getMax(a);
        getMax(b);
    }

    private void getMax(float[] a) {
        float[] newArray;
        int j = 0;

        if (a.length%2 == 0) {
            newArray = new float[a.length/2];
            for (int i = 0; i < a.length - 1; i = i+2) {
                newArray[j] = a[i] + a[i+1];
                j++;
            }
        }
        else {
            newArray = new float[(a.length - 1)/2 + 1];
            for (int i = 0; i < a.length - 2; i = i+2) {
                newArray[j] = a[i] + a[i+1];
                j++;
            }
            newArray[newArray.length - 1] = a[a.length - 1];
        }
        System.out.println(Arrays.toString(newArray));

        float max = newArray[0];
        for (int i = 1; i < newArray.length; i++) {
            if(newArray[i] > max) {
                max = newArray[i];
            }
        }
        System.out.println("max = " + max);
    }
}
