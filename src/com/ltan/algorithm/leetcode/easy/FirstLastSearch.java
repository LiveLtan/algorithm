package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Details: from leetcode 34
 * see leetcode 278 (Easy)
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * created by ltan on 2019-01-20
 */
public class FirstLastSearch {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] {-1, -1};
            if(nums.length < 1) {
                return res;
            }
            // first index
            int l = 0, r = nums.length - 1, mid;
            while (l < r) {
                mid = l + (r - l) / 2;
                int c = nums[mid];
                if(target <= c) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if(nums[l] == target) {
                res[0] = l;
            } else {
                return res;
            }

            // last index
            l = 0;
            r = nums.length - 1;
            while (l <= r) {
                mid = l + (r - l) / 2;
                int c = nums[mid];
                if(target < c) {
                    r = mid - 1;
                } else if(target >= c) {
                    l = mid + 1;
                }
            }
            if(r >= 0 && nums[r] == target) {
                res[1] = r;
            }
            return res;
        }
    }

    public static void run() {
        Solution s = new Solution();
        int[] nums = Utils.generateArrayByString("[5,7,8,8,9,9,9,9,10]");
        //int[] nums = Utils.generateArrayByString("[5,7,7,8,8,10]");
        //int[] nums = Utils.generateArrayByString("[1,2,3]");
        //int[] nums = Utils.generateArrayByString("[0]");

        //int[] r = s.searchRange(nums, 10);
        //int[] r = s.searchRange(nums, 9);
        //int[] r = s.searchRange(nums, 8);
        //int[] r = s.searchRange(nums, 7);
        //int[] r = s.searchRange(nums, 6);
        //int[] r = s.searchRange(nums, 5);
        int[] r = s.searchRange(nums, 3);
        System.out.println("index:");
        Utils.printArray(r);
    }
}