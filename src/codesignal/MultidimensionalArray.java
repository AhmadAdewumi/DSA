package codesignal;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        String[][] strArr = {
                {"Apt 101", "Apt 102", "Apt 103"},
                {"Apt 201", "Exit Floor", "Apt 203"},
                {"Apt 301", "Apt 302", "Apt 303"}
        };

        strArr[0][1] = "Apt 110";
        
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                System.out.print(strArr[i][j] + ", ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(array));
        System.out.println(array[1][0]);
    }

}
