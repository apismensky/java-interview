package com.apismensky;

/**
 * https://leetcode.com/articles/container-with-most-water/ Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two
 * lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 */
public class ContainerWithMostWater {

    // Brute force solution N ^ 2
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxArea = Math.max(maxArea, Math.min(height[i],  height[j]) * (j - i));
        return maxArea;
    }

    // Most efficient - Complexity N
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = (right - left) * Math.min(leftHeight, rightHeight);
            maxArea = Math.max(maxArea, area);
            if (leftHeight < rightHeight) {
                // keep right, discard left
                left++;
            } else {
                // keep left, discard right
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();

        int area = container.maxAreaBruteForce(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(area);

        int area2 = container.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(area2);
    }
}
