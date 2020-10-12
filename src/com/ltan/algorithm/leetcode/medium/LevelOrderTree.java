package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Detail: from Leetcode 102
 * <p>
 * Created by tanlin on 2020-10-13
 */
public class LevelOrderTree {
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
            ArrayDeque<TreeNode> nodes2 = new ArrayDeque<>();
            nodes.addLast(root);
            while (!nodes.isEmpty()) {
                List<Integer> arr = new ArrayList<>();
                nodes2.clear();
                while (!nodes.isEmpty()) {
                    TreeNode n = nodes.poll();
                    if (n != null) {
                        arr.add(n.val);

                        if (n.left != null) {
                            nodes2.addLast(n.left);
                        }
                        if (n.right != null) {
                            nodes2.addLast(n.right);
                        }
                    }
                }
                nodes.addAll(nodes2);
                res.add(arr);
            }

            return res;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = Utils.generateTreeNode(values);
        System.out.println("level order " + solution.levelOrder(root));
    }
}
