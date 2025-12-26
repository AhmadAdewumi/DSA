package arrays;

public class PrintArray {
    public void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo(){
//        int[] array =new int[5];
        int[] array = {5,4,7,8,9,10};
        printArray(array);
    }

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();
        printArray.arrayDemo();
    }
}
