package GFG.arrays;

public class MissingNum {
    static int findMissingNum(int[] arr) {
        int n = arr.length + 1; //this covers the number from 1 to the last no present
        //e.g for length 7, the no. there is 1..8

        //e,g for 7 ,for each possible number 1 to 8, we check if it is present in the array
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            //this loops thru the array looking for the current number
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            //if the number is not present, we mark found, we return i, which is the missing number
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    //just a simple form of hashin, an array serve as the hash table
    static int missingNumUsingHashing(int[] arr) {
        //e,g 7, the full set of the no. is 1..8
        int n = arr.length + 1;

        //we create an arr with size n+1 and all values 0
        //index 0 unused , only index 1 to n is used
        int[] hash = new int[n + 1];

        //store freq of the element i,e
        //for every number in the arr, we increase its count
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
    -- the formula for sum of first n numbers ia n*(n+1)/2
    -- if the array is supposed to contain all numbers from 1 to 8 but one is missing,
    -- the total sum of the array will be less than 36 by exactly the missing number.
    -- we use long to avoid overflow in case the sum is large
     */
    static int usingSumOf_n_Numbers(int[] arr) {
        long n = arr.length + 1;

        long sum = 0;

        //first calc. the sum of the numbers in the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        //we calculate the expected sum, using long to avoid overflow
        long expectedSum = n * (n + 1) / 2;

        //perform subtraction of the expSum and sum , cast to int and return the diff as the missing number
        return (int) (expectedSum - sum);
    }

    static int missingNumUsingXOR(int[] arr) {
        int n = arr.length + 1;
        int xor1 = 0, xor2 = 0;

        //perform xor on all array elements
        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ arr[i];
        }

        //XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor2 = xor2 ^ i;
        }

        //The missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNumUsingXOR(arr));
    }

}
