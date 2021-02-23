package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

public class MergeArray {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int actual = m;
            int k = 0;
            for (int i = 0; i < n; i++) {
                int num2 = nums2[i];
                for (int j = k; j < actual; j++) {
                    if (num2 < nums1[j]) {
                        k = j;
                        break;
                    }
                    if (j >= m) {
                        k = actual;
                    }
                }
                if (k == 0 && num2 >= nums1[0]) {
                    k = actual;
                }
                for (int j = (m + n) - 1; j >= k && j > 0; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[k] = num2;
                actual++;
            }
        }

        /**
         * ref https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
         */
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j])
                    nums1[k--] = nums1[i--];
                else
                    nums1[k--] = nums2[j--];
            }
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void run() {
        Solution solution = new Solution();
        // int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        // int[] nums2 = new int[] {2, 5, 6};
        // solution.merge(nums1, 3, nums2, 3);
        // int[] nums1 = new int[] {1,2,0};
        // int[] nums2 = new int[] {2};
        // solution.merge(nums1, 2, nums2, 1);

        int[] nums1 = new int[]{4, 4, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 7};
        solution.merge2(nums1, 3, nums2, 3);
        Utils.printArray(nums1);
    }
}
