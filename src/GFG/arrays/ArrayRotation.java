package GFG.arrays;

public class ArrayRotation {
    //CONSIDERING RIGHT ROTATION
    //NAIVE APPROACH
    static void rotateArray(int[] arr, int d) {
        int n = arr.length;

        for (int i = 0; i < d; i++) {//we perform the iteration d times
            int lastElement = arr[n - 1]; //save the last element

            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1]; //shift each elements one step to the right
            }

            arr[0] = lastElement; //put the saved last element in the front
        }
    }

    static void rotateUsingTempArr(int[] arr, int d) {
        int n = arr.length;

        /*
        -- given n = 6
        -- given d = 8, rotating 2 times is the same as rotating  8 times
        -- given d = 15, rotating 7 times is the same as rotating 15 timesx
         */
        d = d % n; //effective time to rotate incase the one given is greater thn the no. of elements given

        int[] temp = new int[n]; //create a new array of size n

        //copy the first d elements to the front of the temp array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }

        //copy the first n-d elements, i.e the elements after the one occupied by the rotated ones to the back of temp
        //this now contains the rotated array
        for (int i = 0; i < n - d; i++) {
            temp[i + d] = arr[i];
        }

        //copy the elements of the temp arr into the original arr
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    //JUGGLING ALGORITHM
    static void rotateArrByJuggling(int[] arr, int d) {
        int n = arr.length;

        //This handles the scenario when d is greater than the size of the array
        d = d % n;
        if (d == 0) return;

        //symbolizes the number of sets the array can be divided into without any overlap
        int cycles = gcd(n, d); //gcd(6,2) = 2, then we have 2 cycles like that

        for (int i = 0; i < cycles; i++) {
            //the starting index of the current cycle
            int currentIndex = i;
            int currentElement = arr[currentIndex];

            do {
                //find the next index where the current element should go
                int nextIndex = (currentIndex + d) % n;

                //we store what ic currently at the next index
                int nextElement = arr[nextIndex];

                //after storing, we move our current element to that position i.e next index
                arr[nextIndex] = currentElement;

                //now the nextElement(the stored one) now becomes the new current element
                currentElement = nextElement;

                //jump forward to the `nextIndex`
                currentIndex = nextIndex;
            } while (currentIndex != i);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    //REVERSAL ALGORITHM
        /*
    -- reverse the first d elements
    -- reverse the first n-d elements
    -- reverse first the whole array
     */
    static void rotateArrLeftUsingRevAlgo(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        //reverse the first d elements
        reverseArr(arr, 0, d - 1);
        //reverse the remaining n-d elements
        reverseArr(arr, d, n - 1);
        //reverse the whole array
        reverseArr(arr, 0, n - 1);
    }

    static void rotateArrRightUsingRevAlgo(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        //reverse the last d elements
        reverseArr(arr, n - d, n - 1);
        //reverse the first n-d elements
        reverseArr(arr, d, n - d - 1);
        //reverse the whole array
        reverseArr(arr, 0, n - 1);
    }


    static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotateArrLeftUsingRevAlgo(arr, 2);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

}
