package leetcode;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int arrLength = height.length;

        int max = 0;

        for (int i = 0; i < arrLength; i++) {
            for (int j = i; j < arrLength; j++) {
                int minLength = Math.min(height[i], height[j]);

                int area = (j - i) * minLength;

                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }

    public static int maxAreaUsingTwoPointers(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;

            int currentArea = currentWidth * currentHeight;

            maxArea = Math.max(currentArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println("Max Area is: " + maxArea(heights));
    }
}
