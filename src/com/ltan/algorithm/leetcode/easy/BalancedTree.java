package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 110
 * <p>
 * Created by tanlin on 2020-10-23
 */
public class BalancedTree {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int dl = depth(root.left);
            int dr = depth(root.right);
            return Math.abs(dl - dr) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }

        /**
         * get depth first
         * @param root
         * @return
         */
        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 1;
            int left = depth + depth(root.left);
            int right = depth + depth(root.right);
            return left > right ? left : right;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        // int[] nums = new int[]{3, 9, 20, -1, -1, 15, 7};
        // int[] nums = new int[]{1, 2, 2, 3, 3, -1, -1, 4, 4};
        int[] nums = new int[]{1, 2, -1, 4, 5, 6, -1, 8};
        TreeNode root = Utils.generateTreeNode(nums);
        Utils.checkTree(root);
        System.out.println(solution.isBalanced(root));
    }
}
