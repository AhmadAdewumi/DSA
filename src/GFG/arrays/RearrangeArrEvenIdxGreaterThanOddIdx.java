package GFG.arrays;

public class RearrangeArrEvenIdxGreaterThanOddIdx {
    //method to swap the elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //we will be considering 1 based indexing as 0 is not even nor odd
    static void reArrange(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if ((i % 2 == 0) && (arr[i] < arr[i - 1])) {
                swap(arr, i, i - 1);
            } else if ((i % 2 != 0) && (arr[i] > arr[i - 1])) {
                swap(arr, i, i - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 5};
        reArrange(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
