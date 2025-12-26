package arrays;

/***
 * declare a method that takes an array as a parameter and also returns an array
 * initialize a variable j that handles the zero elements
 * crate a for loop where i handles the non-zero elements
 * check if the value of an arr[i] is not zero  and that of j is zero
 * if yes , swap the elements
 * also  there should be a condition to check if arr[j] is not equal to zero for each iteration
 * if yes, increment the variable j
 * return the array
 */
public class MoveZeros {
    public int[] moveZeros(int[] arr) {
        int n = arr.length;
        int j = 0;// handles the non zero elements
        for (int i = 0; i < n; i++) { //i handles the zero elements
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        printArray(moveZeros.moveZeros(new int[]{2, 22, 5, 0, 0, 7, 0, 6, 9, 0, 12}));
    }
}

