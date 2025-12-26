package arrays;

public class ReverseArray {
    public static void revArray(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {10,20,30,40,50,60,70,80};
        printArray(array);
        System.out.println();
        revArray(array,0, array.length-1);
        System.out.println("Reversed array");
        printArray(array);
    }
}
