package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Detail: from Leetcode 107
 * <p>
 * Created by tanlin on 2020-10-20
 */
public class LevelReverseOrder {
    private static class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> nodeValues;
            List<List<Integer>> values = new ArrayList<>();
            ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
            ArrayDeque<TreeNode> nodes2 = new ArrayDeque<>();
            nodes.push(root);
            while (!nodes.isEmpty()) {
                nodeValues = new ArrayList<>();
                while (!nodes.isEmpty()) {
                    TreeNode node = nodes.pop();
                    nodeValues.add(node.val);

                    if (node.left != null) {
                        nodes2.addLast(node.left);
                    }
                    if (node.right != null) {
                        nodes2.addLast(node.right);
                    }
                }

                nodes.addAll(nodes2);
                nodes2.clear();
                values.add(0, nodeValues);
            }

            return values;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        TreeNode root = Utils.generateTreeNode(values);
        System.out.println(solution.levelOrderBottom(root));
    }
}
