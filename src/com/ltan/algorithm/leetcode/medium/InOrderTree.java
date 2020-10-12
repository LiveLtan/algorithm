package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * Detail: from Leetcode 94
 * <p>
 * Created by tanlin on 2020-10-12
 */
public class InOrderTree {
    static class Solution {
        /**
         * recursion
         * @param root
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> values = new LinkedList<>();
            inorderTraversal(root, values);
            return values;
        }

        private void inorderTraversal(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, values);
            values.add(root.val);
            inorderTraversal(root.right, values);
        }

        /**
         * iteratively
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> values = new LinkedList<>();
            LinkedList<TreeNode> nodes = new LinkedList<>();
            TreeNode l;
            nodes.add(root);
            while (!nodes.isEmpty()) {
                l = nodes.pollLast();
                while (l != null) {
                    nodes.add(l);
                    l = l.left;
                }
                TreeNode n = nodes.pollLast();
                if (n != null) {
                    values.add(n.val);
                    nodes.add(n.right);
                }
            }
            return values;
        }

        public List<Integer> inorderTraversal3(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> values = new LinkedList<>();
            Stack<TreeNode> nodes = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !nodes.isEmpty()) {
                while (cur != null) {
                    nodes.push(cur);
                    cur = cur.left;
                }
                cur = nodes.pop();
                values.add(cur.val);
                cur = cur.right;
            }
            return values;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[]{1, 2, 3, 4, 5};
        TreeNode root = Utils.generateTreeNode(values);
        System.out.println("in order " + solution.inorderTraversal(root));
        System.out.println("in order " + solution.inorderTraversal2(root));
        System.out.println("in order " + solution.inorderTraversal3(root));
    }
}
