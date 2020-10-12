package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.LinkedList;

/**
 * Detail: from Leetcode 101
 * <p>
 * Created by tanlin on 2020-10-12
 */
public class SymmetricTree {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            // return isSymmetric(root, root);
            return isSymmetric2(root);
        }

        private boolean isSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2 == null;
            }
            if (root2 == null) {
                return false;
            }

            return (root1.val == root2.val
                    && isSymmetric(root1.left, root2.right)
                    && isSymmetric(root1.right, root2.left));
        }

        public boolean isSymmetric2(TreeNode root) {
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            nodes.add(root);
            while (!nodes.isEmpty()) {
                TreeNode t1 = nodes.poll();
                TreeNode t2 = nodes.poll();
                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null) {
                    return false;
                }
                if (t1.val != t2.val) {
                    return false;
                }
                nodes.add(t1.left);
                nodes.add(t2.right);
                nodes.add(t1.right);
                nodes.add(t2.left);
            }

            return true;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[] {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = Utils.generateTreeNode(values);
        System.out.println("is symmetric " + solution.isSymmetric(root));
    }
}
