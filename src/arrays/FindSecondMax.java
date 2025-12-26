package arrays;

public class FindSecondMax {

    public static int secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int result = secondMax(new int[] {10,20,30,40,50,60,70,80});
        System.out.println("Second maximum value is : " + result);
    }

}
