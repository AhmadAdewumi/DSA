package bytebtego.two_pointers;

import java.util.Arrays;

public class NextLexicographicalSequence {
    public static String next_lexicographical_sequence(String s) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;

        //-- find and set pivot
        int pivot = -1;
        for (int i = n - 2; i > 0; i--) {
            if (sArr[i] < sArr[i + 1]) {
                pivot = i;
                break;
            }
        }

        //-- if no pivot is found
        if (pivot == -1) {
            reverse(sArr, 0, n - 1);
            return new String(sArr);
        }

        //-- find j, the first index from right where arr[j] > arr[i]
        int j = n - 1;
        while (j > pivot && sArr[j] < sArr[pivot]) {
            j--; //-- continue decreasing while sArr[j] < sArr[pivot], if arr[j] > arr[i], we stop
        }

        //-- swap value at idx i and j
        char temp = sArr[pivot];
        sArr[pivot] = sArr[j];
        sArr[j] = temp;

        reverse(sArr, pivot + 1, n - 1);
        return new String(sArr);
    }

    static void printAllPermutations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String current = new String(arr);
        String first = current;

        do {
            System.out.println(current);
            current = next_lexicographical_sequence(current);
        } while (!current.equals(first));
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(next_lexicographical_sequence("bcd"));
        System.out.println("\n ------------------- Printing all permutations ------------------");
        printAllPermutations("abcd");
    }

}
