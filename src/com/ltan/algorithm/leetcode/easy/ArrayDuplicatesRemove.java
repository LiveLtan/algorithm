package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Details: from leetcode 26
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * created by ltan on 2019-01-13
 */
public class ArrayDuplicatesRemove {
    static class Solution {
        /**
         * Optimise for the {@link #removeDuplicates2(int[])}
         * just O(N), S(1)
         *
         * It's so cleaver, ref. from discussion java
         */
        public int removeDuplicates(int[] nums) {
            int count = 1;
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] != nums[i-1]) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }

        public int removeDuplicates2(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int count = nums.length;
            int equal = 0;
            for (int i = nums.length - 1; i > 0; ) {
                equal = findEqualNumber(nums, i);
                if (equal > 0) {
                    moveElement(nums, i + 1, i - equal + 1, count);
                    count -= equal;
                    i -= equal;
                } else {
                    i--;
                }
            }
            return count;
        }

        private void moveElement(int[] nums, int from, int to, int newLength) {
            if (from > nums.length - 1) {
                from = nums.length - 1;
            }
            if (to < 0) {
                to = 0;
            }
            int j = to;
            for (int i = from; i < newLength; i++) {
                nums[j++] = nums[i];
            }
        }

        private int findEqualNumber(int[] nums, int curIndex) {
            int now = nums[curIndex];
            int n = 0;
            for (int i = curIndex - 1; i >= 0; i--) {
                if (now != nums[i]) {
                    break;
                }
                n++;
            }
            return n;
        }
    }

    public static void run() {
        Solution s = new Solution();
        //int[] nums = Utils.generateArrayByString("[1,1,2]");
        //int[] nums = Utils.generateArrayByString("0,0,1,1,1,2]");
        //int[] nums = Utils.generateArrayByString("0,0,1,1,1,2,2,4,4,5]");
        int[] nums = Utils.generateArrayByString("[0,0,1,1,1,2,2,3,3,4]");
        //int[] nums = Utils.generateArrayByString("0,1,1,1,2,3]");
        int length = s.removeDuplicates(nums);
        System.out.println("length:" + length);
        Utils.printArray(nums, length);
    }
}