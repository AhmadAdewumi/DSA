package GFG.arrays;

public class MinCostToMakeArrSize1 {

    /* --MIN COST TO REDUCE ARRAY SIZE TO ONE
    -- the goal is to reduce the size of the  array to one
    -- pick any pair of elements , remove the larger one so payCost equal to the smaller element
    -- we are using the Greedy approach -> we always include the smallest element in each operation to minimize cost
    -- to get the total cost , no. of operations = n-1, and each costs min(arr) or we call it minVal, so the formula for the total cost is
    -- minVal * (n-1)
     */
    static int minCost(int[] arr) {
        int minVal = arr[0];
        int n = arr.length;

        //finding the minimum value
        for (int i = 1; i < n; i++) {
            if (arr[i] < minVal)
                minVal = arr[i];
        }

        return (n - 1) * minVal;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 7};
        System.out.println(minCost(arr));
    }
}
