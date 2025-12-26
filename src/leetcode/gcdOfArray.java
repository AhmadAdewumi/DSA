package leetcode;

public class gcdOfArray {
    /**
     * -- find the smallest number and the largest number
     * -- and then calculate the gcd of the two
     */
    public static int findGCD(int[] nums) {
        int mn = nums[0];
        int mx = nums[0];

        //-- get the max and min number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mn) {
                mn = nums[i];
            } else if (nums[i] > mx) {
                mx = nums[i];
            }
        }

        //-- assign the smallest num to gcd
        int gcd = mn;
        while (gcd > 0) {
            if (mn % gcd == 0 && mx % gcd == 0) {
                return gcd;
            }
            gcd--;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{12,5,6,8,3};
        System.out.println("The GCD of the smallest and largest num in this array is: " + findGCD(nums));
    }
}
