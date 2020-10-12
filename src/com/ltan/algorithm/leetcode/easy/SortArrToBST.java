package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 108
 * <p>
 * Created by tanlin on 2020-10-23
 */
public class SortArrToBST {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return sortBst(nums, 0, nums.length - 1);
        }

        private TreeNode sortBst(int[] nums, int s, int e) {

            if (e <= s) {
                return new TreeNode(nums[e]);
            } else if (e == 1) {
                TreeNode root = new TreeNode(nums[e]);
                root.left = new TreeNode(nums[s]);
                return root;
            }
            int r = (e + s) / 2;
            TreeNode root = new TreeNode(nums[r]);
            if (e - s == 1) {
                root.right = new TreeNode(nums[e]);
                return root;
            }
            if (e - s == 2) {
                root.left = new TreeNode(nums[s]);
                root.right = new TreeNode(nums[e]);
                return root;
            }
            root.left = sortBst(nums, s, r - 1);
            root.right = sortBst(nums, r + 1, e);
            return root;
        }

        /**
         * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35220/My-Accepted-Java-Solution
         */
        private TreeNode sortBst2(int[] nums, int s, int e) {
            if (e < s) {
                return null;
            }
            int r = (e + s) / 2;
            TreeNode root = new TreeNode(nums[r]);
            root.left = sortBst(nums, s, r - 1);
            root.right = sortBst(nums, r + 1, e);
            return root;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] nums = new int[]{-10, -6, -3, 0, 5, 9, 10};
        TreeNode root = solution.sortedArrayToBST(nums);
        Utils.printTreeIn(root);
    }
}
