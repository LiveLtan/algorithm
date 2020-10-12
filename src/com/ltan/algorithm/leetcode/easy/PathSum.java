package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 112
 * <p>
 * Created by tanlin on 2020-10-30
 */
public class PathSum {
    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == sum;
            }
            return hashValue(root.left, sum - root.val) || hashValue(root.right, sum - root.val);
        }

        private boolean hashValue(TreeNode node, int value) {
            if (node == null) {
                return false;
            }
            boolean ret = false;
            if (node.left != null) {
                ret = hashValue(node.left, value - node.val);
            }
            if (ret) {
                return true;
            }
            if (node.right != null) {
                ret = hashValue(node.right, value - node.val);
            }
            if (ret) {
                return true;
            }
            if (node.left == null && node.right == null) {
                return node.val == value;
            }
            return false;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        // int[] nums = new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1};
        // int[] nums = new int[]{2, -1, 3, -1, 4, -1, 5, -1, 6};
        // int[] nums = new int[]{1};
        // int[] nums = new int[]{1,2};
        int[] nums = new int[]{1,2,-1,3,-1,-1,-1,4,-1,-1,-1,-1,-1,-1,-1};
        TreeNode root = Utils.generateTreeNode(nums);
        Utils.checkTree(root);
        System.out.println(solution.hasPathSum(root, 6));
    }
}
