package arrays;

import java.util.Arrays;

public class RemoveEven {
    public int[] returnOdd(int[] arr) {
        int oddCount = 0; //to keep the odd count
        for (int i = 0; i < arr.length; i++) { //for loop to count the no of odd elements
            if (arr[i] % 2 != 0) {
                oddCount++; //to increment the odd count
            }
        }

        int[] oddArray = new int[oddCount]; // initialize an array with the odd count
        int index = 0; // to store the index to keep the odd elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0){
                oddArray[index] = arr[i];
                index++;
            }
        }

        return oddArray;
    }

    public void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveEven oddArr = new RemoveEven();
        int[] result = oddArr.returnOdd(new int[]{32,57,64,87,90,56,43,26,24,72});
        oddArr.printArray(result);
        System.out.println();
    }
}
