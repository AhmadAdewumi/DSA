package arrays;

public class BinarySearch {
//    int[] nums = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    public static int search(int[] arrNum,int key){
        int low =0;
        int high = arrNum.length-1;
//        int result =0;

        while (high>=low){
            int mid = (low+high)/2;
            if (key<arrNum[mid]){
                high = mid-1;
            }
            else if (key==arrNum[mid]) {
                return mid;
            }else {
                low = mid+1;
            }
        }
        return -low-1; // return the index
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(BinarySearch.search(nums,2));
    }
}
