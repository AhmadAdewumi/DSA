package GFG.arrays;

public class IsArraySorted {

    //Iterative Approach
    public static boolean isSorted(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i])
                return false;
        }
        return true;
    }

    //Recursive Approach
    static boolean isSortedRecursively(int[] arr, int n){
        //base case -- normal, an array of size 1 or 0 is auto sorted
        if (n ==1 || n==0){
            return true;
        }

        //check if the two ending elements are sorted
        return arr[n-1] >= arr[n-2] && isSortedRecursively(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {20,20,30,40,50};

        if (isSortedRecursively(arr, arr.length)){
            System.out.println("TRUE");
        }
        else
            System.out.println("FALSE");
     }
}
