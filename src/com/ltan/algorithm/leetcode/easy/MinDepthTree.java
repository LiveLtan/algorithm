package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayDeque;

/**
 * Detail: from Leetcode 111
 * <p>
 * Created by tanlin on 2020-10-23
 */
public class MinDepthTree {
    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            ArrayDeque<TreeNode> que = new ArrayDeque<>();
            ArrayDeque<TreeNode> que2 = new ArrayDeque<>();
            int level = 1;
            que.add(root);
            while (!que.isEmpty()) {
                // add current level nodes all
                while (!que.isEmpty()) {
                    TreeNode node = que.poll();
                    // break if leaf node
                    if (node.left == null && node.right == null) {
                        return level;
                    }
                    if (node.left != null) {
                        que2.add(node.left);
                    }
                    if (node.right != null) {
                        que2.add(node.right);
                    }
                }
                que.addAll(que2);
                // clear nodes of current level
                que2.clear();
                level++;
            }
            return level;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 9, 20, -1, -1, 15, 7};
        // int[] nums = new int[]{2, -1, 3, -1, 4, -1, 5, -1, 6};
        // int[] nums = new int[]{1, 2, -1, 4, 5, 6, -1, 8};
        TreeNode root = Utils.generateTreeNode(nums);
        Utils.checkTree(root);
        System.out.println(solution.minDepth(root));
    }
}
