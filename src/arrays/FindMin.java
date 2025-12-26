package arrays;

public class FindMin {
    public static int findMin(int[] arr) {

        //edge case
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty nor null");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[0]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int result = findMin(new int[]{20, 30, 40, 50, 2, 60, 70, 80});
//        int result = findMin(null);
        System.out.println("min value : " + result);
    }
}
