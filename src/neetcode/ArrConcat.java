package neetcode;

public class ArrConcat {
    static int[] arrConcat(int[] arr) {
        int n = arr.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
            ans[i + n] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 1, 2};
        int[] concatArr = arrConcat(arr);

        for (int i = 0; i < concatArr.length; i++) {
            System.out.print(concatArr[i] + " ");
        }
    }
}
