package GFG.arrays;

import java.util.HashSet;

/*
-- The goal is to find if any two identical elements in the array occur within k indices of each other --
 */
public class CheckDuplicatesWithinK {
    static boolean duplicatesWithinK(int[] arr, int k) {
        int n = arr.length;

        //outer loop , to loop thru the whole array
        for (int i = 0; i < n; i++) { //O(n*k)
            //-- checks the next k elements after the current element to see if any of them are equal to it
            //-- i.e if the outer loop is at index i, the inner loop looks at the element i+1, i+2, .. , i+k
            for (int c = 1; c <= k && (i + c) < n; c++) {//i+c gives us the index of the element we are comparing against
                int j = i + c; //represents the index of the element we are comparing with

                if (arr[i] == arr[j])
                    return true;
            }
        }

        return false;
    }

    /*
    -- add the current element
    -- if it is already in the set, return true
    -- if the window grows beyond k, remove the element that is k steps behind
     */
    static boolean usingHashset(int[] arr, int k) {
        int n = arr.length;

        //we create an empty hashset(keeps unique values)
        //this keeps track of elements we have seen within the last 'k' distance
        HashSet<Integer> set = new HashSet<>();

        //loop through every element in the array
        for (int i = 0; i < n; i++) {

            //if the current element already exists in the set,
            //it means we found a duplicate within k distance
            if (set.contains(arr[i]))
                return true;

            //otherwise add the current element to the set
            set.add(arr[i]);

            //once the window exceeds k, like our i >= k,
            //we remove the element that is too far i.e (arr[i-k])
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

//        if we finish the loop with no duplicates found within k distance
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(usingHashset(arr, 3) ? "Yes" : "No");
    }
}
