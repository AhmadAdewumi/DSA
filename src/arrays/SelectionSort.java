package arrays;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length-1 ; i++) {//iterate through the array
            int min_index = i; //assume the minimum value is at index 0

            for (int j = i+1; j < arr.length; j++) { //iterate through the unsorted portion again starting from the element after the current index of i(this loop is
                //for comparing one element to the other
                if (arr[j] < arr[min_index]){ //check if any of the remaining value is less than the value of i
                    min_index=j; // set the minimum index to the current one
                }
            }
            /***
             * swap the values
             */
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

    }

    static void printArray(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

//        Arrays.sort(arr);
        System.out.print("Original array: ");
        printArray(arr);

        selectionSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
