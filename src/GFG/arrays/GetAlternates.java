package GFG.arrays;

import java.util.ArrayList;

public class GetAlternates {
    static void getAlternatesUsingRecursion(int[] arr, int idx, ArrayList<Integer> result){
        if (idx < arr.length){
            result.add(arr[idx]);
            getAlternatesUsingRecursion(arr, idx + 2, result);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20,25,27,29,31,33};
        ArrayList<Integer> result = new ArrayList<>();
        getAlternatesUsingRecursion(arr, 0, result);

        for (int x : result){
            System.out.println(x + " ");
        }
    }
}
