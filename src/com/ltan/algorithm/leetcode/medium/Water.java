package com.ltan.algorithm.leetcode.medium;


/**
 * Detail: from Leetcode 11
 * <p>
 * Created by tanlin on 2020-12-24
 */
public class Water {
    public static class Solution {
        public int maxArea(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            if (height.length == 1) {
                return height[0];
            }
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = 1; j < height.length; j++) {
                    int min = Math.min(height[i], height[j]);
                    max = Math.max(max, min * (j - i));
                }
            }
            return max;
        }

        /**
         * ref: https://leetcode.com/problems/container-with-most-water/submissions/
         */
        public int maxArea2(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            if (height.length == 1) {
                return height[0];
            }
            int max = 0;
            int l = 0;
            int r = height.length - 1;
            while (l < r) {
                max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r]) {
                    l++;
                } else {
                    r--;
                }
            }
            return max;
        }
    }

    public static void run() {
        Solution s = new Solution();
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] num = new int[]{1, 1};
        // int[] num = new int[]{4, 2, 3, 1, 4};
        // int[] num = new int[]{1, 2, 1};
        // System.out.println(s.maxArea(num));
        System.out.println(s.maxArea2(num));
    }
}
