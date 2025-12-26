package GFG.arrays;

public class SumOfAllSubArrays {
    //NAIVE APPROACH
    static int sumOfAllSubArrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) { //picks the starting index
            int subArrSum = 0;

            for (int j = i; j < n; j++) {//extends to the end index
                subArrSum += arr[j]; //perform sum for subarray
                totalSum += subArrSum; //calculate s the total sum
            }
        }
        return totalSum;
    }

    //ELEMENT CONTRIBUTION METHOD
    /*
    -- how many subarrays include a particular element &
    -- we multiply the element by the number of subarrays it contributes to
    -- THE FORMULA IS -- arr[i] * (i+1) * (n-i)
     */
    static int usingElementContributionApproach(int[] arr){
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i] * (i+1) * (n-i);
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
//        System.out.println(sumOfAllSubArrays(arr));
        System.out.println(usingElementContributionApproach(arr));
    }
}
