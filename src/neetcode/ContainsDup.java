package neetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDup {
    static boolean containsDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;

    }

    static boolean containsDup01(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(arr[i])) return true;
            seen.add(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4};
        System.out.println(containsDup01(arr));
    }
}