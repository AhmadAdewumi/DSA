package GFG.arrays;

import java.util.ArrayList;

public class MissingAndRepeatingNumbers {
    static ArrayList<Integer> findRepeatingAndMissing(int[] arr) {
        int n = arr.length;

        //we create a frequency arr of size n+1 to keep track of the num count
        int[] freq = new int[n + 1]; //initially all zeroes
        int repeating = -1;
        int missing = -1;

        //we count the frequency if each element
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        //we identify the missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0)
                missing = i;
            else if (freq[i] == 2) {
                repeating = i;
            }
        }

//        we store the result in an array list
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }

    static ArrayList<Integer> usingArrayMarking(int[] arr) {
        int n = arr.length;
        int repeating = -1;

        // traverse the array and mark visited indices
        // by negating the value at index arr[i] - 1
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);

            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            } else {
                //
                repeating = val;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }

    static ArrayList<Integer> usingFormula(int[] arr) {
        int n = arr.length;

        int s = (n * (n + 1)) / 2; //expected sum
        int ssq = (n * (n + 1) * (2 * n + 1)) / 6; //expected sum of squares

        int missing, repeating = 0;

        //subtracting actual sums of the array from the expected sums
        for (int i = 0; i < n; i++) {
            s -= arr[i];
            ssq -= arr[i] * arr[i];
        }

        // Let x  = missing number , y = repeating number
        // s = x - y --> difference of missing and repeating
        // ssq = x^2 - y^2 = (x - y)(x + y) = s * (x + y) -- difference of squares
        // => x + y = ssq / s
        // => x = (s + ssq / s) / 2
        // => y = x - s
        missing = (s + ssq / s) / 2;
        repeating = missing - s;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> result = usingFormula(arr);

        System.out.println(result.get(0) + " " + result.get(1));
    }
}
