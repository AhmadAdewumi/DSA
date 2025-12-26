package GFG.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueNumber {
    static int findUniqueNoUsingXor(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }

        return result;
    }

    static int usingHashMap(int[] arr) {
        // hashmap to store the freq/ count of each element
        //with the number as key and freq/count s value
        HashMap<Integer, Integer> count = new HashMap<>();

        //we store the freq of each element
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //we return the value that is unique i.e count =,m1
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};
        System.out.println(usingHashMap(arr));
    }
}
