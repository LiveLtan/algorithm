package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.*;

/**
 * Detail: from Leetcode 103
 * <p>
 * Created by tanlin on 2020-10-15
 */
public class ZigLevelOrderTree {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> nodes = new Stack<>();
            List<TreeNode> nodes2 = new LinkedList<>();
            nodes.push(root);
            boolean evenLevel = false;
            while (!nodes.isEmpty()) {
                List<Integer> arr = new ArrayList<>();
                nodes2.clear();
                while (!nodes.isEmpty()) {
                    TreeNode n = nodes.pop();
                    if (n != null) {
                        arr.add(n.val);
                        if (evenLevel) {
                            if (n.right != null) {
                                nodes2.add(n.right);
                            }
                            if (n.left != null) {
                                nodes2.add(n.left);
                            }
                        } else {
                            if (n.left != null) {
                                nodes2.add(n.left);
                            }
                            if (n.right != null) {
                                nodes2.add(n.right);
                            }
                        }
                    }
                }
                evenLevel = !evenLevel;
                nodes.addAll(nodes2);
                res.add(arr);
            }

            return res;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[]{3, 9, 20, 2, 1, 15, 7, 11, 12, 13, 14, 16, 17, 18, 19, 32, 33, 34};
        TreeNode root = Utils.generateTreeNode(values);
        Utils.checkTree(root);
        System.out.println("level order " + solution.levelOrder(root));
    }
}
