package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Details: from leetcode 35
 * see leetcode 278 (Easy)
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * created by ltan on 2019-01-19
 */
public class SearchInsert {
    static class Solution {
        /**
         *
         * @param nums array
         * @param target t
         * @return index insert or equal
         */
        public int searchInsert(int[] nums, int target) {
            int f = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
                if (target > nums[f]) {
                    f = i + 1;
                }
            }
            return f;
        }

        /**
         * Use binary search
         * Optimised {@link #searchInsert(int[], int)}
         */
        public int searchInsert2(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            int mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    public static void run() {
        Solution s = new Solution();
        int[] nums = Utils.generateArrayByString("[1,3,5,6]");
        //int index = s.searchInsert(nums, 5);
        //int index = s.searchInsert(nums, 2);
        //int index = s.searchInsert(nums, 7);
        //int index = s.searchInsert(nums, 0);
        int index = s.searchInsert(nums, 10);
        System.out.println("index:" + index);
    }
}