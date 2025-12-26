package GFG.arrays;

public class MinimumIncrementByK {

    /*
    -- this is used to find the number of times we need to add the
    -- constant k to each element to make all the elements equal
    -- pick the max number
    -- find the difference between the max number and the element
    -- then divide by k formula -> (max - arr[i]) / k
    -- if all are equal , 0 is returned
    -- if it is not possible (i.e) diff/k != 0, we return -1
     */
    static int minOperations(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0]; //take the first element as the maximum

        //find the maximum value
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        //used to keep the number of total operations
        int totalOperations = 0;

        for (int i = 0; i < n; i++) {
            int diff = max - arr[i];

            if (diff % k != 0)
                return -1;

            totalOperations += (diff / k);
        }

        return totalOperations;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 19, 16};
        int k1 = 3;
        System.out.println(minOperations(arr1, k1));

        int[] arr2 = {4, 4, 4, 4};
        int k2 = 3;
        System.out.println(minOperations(arr2, k2));

        int[] arr3 = {4, 2, 6, 8};
        int k3 = 3;
        System.out.println(minOperations(arr3, k3));
    }
}
