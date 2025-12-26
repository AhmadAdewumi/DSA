package GFG.arrays;

public class PrintSubArrays {

    //BRUTE FORCE ==
    static void subArray(int[] arr) {
        int n = arr.length;

        //i is the starting point of each subarray -- moves from the beginning of the array to its end
        for (int i = 0; i < n; i++) { //runs n times
            //j is the end of each subarray -- for a fixed start i, j moves from i to n-1
            for (int j = i; j < n; j++) { //runs n-i times
                //responsible for printing --k walks from i to j to print the elements of the subarray
                for (int k = i; k <= j; k++) {// since this prints elements from i to j, it depends on the number of input -> O(n)
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //RECURSIVE VERSION
    static void subArrayRecursively(int[] arr, int start, int end) {
        // Base condition: if 'end' has reached the array length, stop recursion entirely
        if (end == arr.length) //
        {
            return;
        }

        /*
         * If start > end, it means we’ve printed all subarrays that end at this 'end' index.
         * Example: for end = 1, we’ve printed [1,2] and [2].
         * Now, move to the next 'end' position (end + 1)
         * and reset start to 0 so we can begin again from the start of the array.
         */
        else if (start > end) {
            subArrayRecursively(arr, 0, end + 1);
        }

        /*
         * Otherwise, start <= end:
         * - We have a valid subarray from 'start' to 'end'
         * - Print it
         * - Then move 'start' forward (start + 1)
         *   to get the next subarray that ends at the same 'end'
         */
        else {
            System.out.print("[");

            // Print all elements between 'start' and 'end'
            // Example: if start=0, end=2 -> print arr[0], arr[1], arr[2]
            for (int i = start; i < end; i++) {
                System.out.print(arr[i] + ", ");
            }

            // Print the last element (arr[end]) then close the bracket
            System.out.println(arr[end] + "]");

            // Move start forward by 1 (exploring subarrays starting further right)
            subArrayRecursively(arr, start + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        int[] numbers = new int[50];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = i++;
//        }
        subArrayRecursively(arr, 0, 0);
    }

}


