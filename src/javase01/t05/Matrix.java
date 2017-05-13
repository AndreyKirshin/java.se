package javase01.t05;

import java.util.Arrays;

public class Matrix {
    int MATRIX_SIZE = 8;
    public void showMeMatrix(){
        int[][] a = new int[MATRIX_SIZE][MATRIX_SIZE];

        for(int i = 0; i < a.length; i++) {
            int len = a[i].length;
            for (int j = 0; j < len; j++) {
                if(j == i | len-j-1 == i) {
                    a[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(a[i]));

        }

    }
}
