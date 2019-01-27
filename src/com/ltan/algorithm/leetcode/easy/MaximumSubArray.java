package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Details: from leetcode 53
 * may be a O(log N) solution ?
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * created by ltan on 2019-01-26
 */
public class MaximumSubArray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int tmp = nums[0];
            int sum = nums[0];
            int l = 0, r = 0;
            for (int i = 1; i < nums.length; i++) {
                if (tmp >= 0) {
                    tmp += nums[i];
                } else {
                    tmp = nums[i];
                    l = r = i;
                }
                if(tmp > sum) {
                    sum = tmp;
                    r = i;
                }
            }
            return sum;
        }
    }

    public static void run() {
        Solution s = new Solution();
        int[] nums = Utils.generateArrayByString("[-2,1,-3,4,-1,2,1,-5,4,9]");
        //int[] nums = Utils.generateArrayByString("[-2,-3,-1,-2]");
        //int r = s.maxSubArray(nums);
        int r2 = s.maxSubArray(nums);
        System.out.println("result:" + r2);
    }
}