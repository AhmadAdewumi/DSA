package neetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static int[] performTwoSums(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((i != j) && ((nums[i] + nums[j]) == target)) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /// -- One Pass HashMap version
    static int[] onePassOp(int[] nums, int target) {
        Map<Integer, Integer> seenNumbers = new HashMap<>();

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentNumber = nums[currentIndex];
            int neededNumber = target - currentNumber;

            if (seenNumbers.containsKey(neededNumber)) {
                return new int[]{seenNumbers.get(neededNumber), currentIndex};
            }

            seenNumbers.put(currentNumber, currentIndex);
        }

        return new int[]{-1, -1};
    }

    //-- Two Pass Hashmap version
    static int[] twoPassOP(int[] nums, int target) {
        Map<Integer, Integer> numberIndexMap = new HashMap<>();

        //-- Store everything first, and index it
        for (int i = 0; i < nums.length; i++) {
            numberIndexMap.put(nums[i], i);
        }

        //-- then search
        for (int i = 0; i < nums.length; i++) {
            int neededNumber = target - nums[i];
            if (numberIndexMap.containsKey(neededNumber) && numberIndexMap.get(neededNumber) != i) {
                return new int[]{i, numberIndexMap.get(neededNumber)};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = onePassOp(new int[]{3, 4, 5, 6}, 7);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}