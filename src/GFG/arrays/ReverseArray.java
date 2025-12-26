package GFG.arrays;

public class ReverseArray {

    //NAIVE APPROACH
    static void naiverReversal(int[] arr) {
        int n = arr.length;

        int[] temp = new int[n];

        //this is to copy elements from the original array to the temp one in reverse order
        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - i - 1];
        }

        //this is to copy the reversed elements back into the original array from the temp. one
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    //TWO POINTERS
    static void reverseUsing2Pointers(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){ //swapping
            int temp  =arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    static void reverseBySwapping(int[] arr){
        int n = arr.length;

        //we iterate over the first half of the array and
        // for every index i, we swap arr[i] with arr[n-i-1]
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5};
//        naiverReversal(arr);

        reverseBySwapping(arr);

//        reverseUsing2Pointers(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
