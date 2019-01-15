package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Details: from leetcode 26
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * created by ltan on 2019-01-13
 */
public class ArrayDuplicatesRemove {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length <= 1) {
                return nums.length;
            }
            int count = nums.length;
            for(int i = 1; i < count - 1; i++) {
                if(nextElement(nums, i) > (i + 1)) {

                }
            }
            for(int i = nums.length - 1; i > 0; i--) {
                if(nums[i] == nums[i - 1]) {
                    count--;
                    nums[i] = 0;
                    nums[i - 2] = nums[i - 1];
                }
            }
            return count;
        }

        private int nextElement(int[] nums, int current) {
            int currentV = nums[current];
            for(int i = current + 1; i < nums.length; i++) {
                if(nums[i] != currentV) {
                    return i;
                }
            }
            return current;
        }
    }

    public static void run() {
        Solution s = new Solution();
        //int[] nums = Utils.generateArrayByString("[1,1,2]");
        //int[] nums = Utils.generateArrayByString("0,0,1,1,1,2]");
        int[] nums = Utils.generateArrayByString("0,0,1,1,1,2,2,4]");
        System.out.println("length:" + s.removeDuplicates(nums));
    }
}