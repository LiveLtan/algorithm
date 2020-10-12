package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 104
 * <p>
 * Created by tanlin on 2020-10-13
 */
public class DepthTree {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int depth = 1;
            int left = depth + maxDepth(root.left);
            int right = depth + maxDepth(root.right);

            return Math.max(left, right);
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[]{1, 2, 3, 4, 5};
        TreeNode root = Utils.generateTreeNode(values);
        System.out.println("level order " + solution.maxDepth(root));
    }
}
