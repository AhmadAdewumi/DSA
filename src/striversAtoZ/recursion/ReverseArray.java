package striversAtoZ.recursion;

import java.util.Arrays;

public class ReverseArray {

    static int[] reverseMyOwnApproach(int[] arr) {
        int l = arr.length;
        int temp;
        for (int i = 0; i < l / 2; i++) {
            temp = arr[i];
            arr[i] = arr[l - 1];
            arr[l - 1] = temp;

            l--;
        }

        return arr;
    }

    static int[] reverseInPlaceBetterWay(int[] arr){
        int l = arr.length;
        int temp;
        for (int i = 0; i < l/2; i++) {
            temp = arr[i];
            arr[i] = arr[l-i-1];
            arr[l-i-1] = temp;
        }

        return arr;
    }

    //-- we are given the length already here
    static int[] reverseArrInPlace(int[] arr, int n){
        int temp;

        for (int i = 0; i < n/2; i++) {
            temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,1,5,1};
        System.out.println("Rhe reverse of the array is: " + Arrays.toString(reverseArrInPlace(arr, 6)));
    }
}
