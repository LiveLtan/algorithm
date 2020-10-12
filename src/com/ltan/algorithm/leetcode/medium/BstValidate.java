package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.Stack;

/**
 * Detail: from Leetcode 98
 * <p>
 * Ref: https://leetcode.com/problems/validate-binary-search-tree/solution/
 *
 * Created by tanlin on 2020-10-15
 */
public class BstValidate {
    static class Solution {

        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            Integer inorder = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (inorder != null && root.val <= inorder) {
                    return false;
                }

                inorder = root.val;
                root = root.right;
            }
            return true;
        }

        public boolean isValidBST2(TreeNode root) {
            return isValidBST2(root, null, null);
        }

        private boolean isValidBST2(TreeNode root, Integer lower, Integer upper) {
            if (root == null) {
                return true;
            }
            int mid = root.val;
            if (root.left != null && root.left.val >= mid) {
                return false;
            }
            if (root.right != null && root.right.val <= mid) {
                return false;
            }
            if (lower != null && lower >= mid) {
                return false;
            }
            if (upper != null && upper <= mid) {
                return false;
            }
            return isValidBST2(root.left, lower, mid) && isValidBST2(root.right, mid, upper);
        }
    }


    public static void run() {
        Solution solution = new Solution();
        // int[] values = new int[]{1, 2, 3, 4, 5};
        int[] values = new int[]{10, 5, 15, -1, -1, 6, 20};
        TreeNode root = Utils.generateTreeNode(values);
        Utils.checkTree(root);
        // System.out.println(solution.isValidBST(root));
        System.out.println(solution.isValidBST2(root));
    }
}
