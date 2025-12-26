public class ResizeArray {
    /***
     * create a method that returns an array and takes an array and the new capacity you want as a parameter
     * create a temporary array with the size of the new capacity
     * copy the content of the first array into the temporary array using a for loop
     * return the temp array
     */

    public int[] resizeArr(int[] arr,int newCapacity){
        int[] temp = new int[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
}
