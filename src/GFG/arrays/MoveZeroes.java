package GFG.arrays;

public class MoveZeroes {
    //NAIVE APPROACH
    static void pushZeroesToEnd(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        //copy all non zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                /*
                -- short form temp[index++] = arr[i]
                 */
                temp[index] = arr[i];
                index++; //increment the index
            }
        }

        //fill remaining position with 0, index may be something like 4 now after incrementing
        while (index < n) {
            temp[index] = 0;
            index++;
        }

        //copy the temp arr to the original array back
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

    }

    //2 traversal
    static void usingTwoTraversalApproach(int[] arr) {
        int n = arr.length;
        int count = 0; //to kee[ track of the non zero elements

        /*
        -- if the element is non zero, replace the element at this index `count`
        -- and increment count
         */
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }

            /*
            -- now that all non zero element has been shifted to the front
            -- make all elements 0 from count to end
             */
            while (count < n)
                arr[count++] = 0;

    }

    //1 TRAVERSAL OR 2  POINTER APPROACH
    /*
    2-pointer technique to push all zeroes to the back

    -- we use count to track the position of the non-zero element and where it should go
    -- i scans the array from the start to the end
    -- whenever we fins a non zero element at arr[i], we swap it with arr[count]
    -- we increment count after placing a non -zero so the zeroes are pushed forward
     */
    static void usingTwoPointerTechnique(int[] arr){
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            //if the element is not zero, move it to the count position
            if (arr[i] != 0){

                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                //increment count to point to the next position for non zero
                count++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 4, 0, 6};
        usingTwoPointerTechnique(arr);

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
