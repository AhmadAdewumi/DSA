package GFG.arrays;

public class RemoveDuplicates {
    //what is used here is the 2 pointer technique, i for reader , idx for writer
    //Also, we are not creating a new arra, we are just overwriting the duplicates
    //so the unique ones are going to occupy the first no. of idx e.g first 5. that was why we returned idx as new size to cut off the remaining parts
    static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return n;

        int idx = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx++] = arr[i]; //post increment here , we first use the value of idx to perform the operation before incrementing it
                // just shorthand for -> arr[idx] = arr[i];  then idx = idx+1, increment the writer idx
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = removeDuplicates(arr);

        for (int i = 0; i < newSize; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
