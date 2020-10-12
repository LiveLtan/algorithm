package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Detail: from Leetcode 95
 * <p>
 * Created by tanlin on 2020-10-14
 */
public class UniqueBinaryTree2 {
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return Collections.emptyList();
            }
            return generate(1, n);
        }

        private List<TreeNode> generate(int start, int end) {
            List<TreeNode> list = new LinkedList<>();
            if (start > end) {
                list.add(null);
                return list;
            }

            if (start == end) {
                list.add(new TreeNode(start));
                return list;
            }

            List<TreeNode> left, right;

            for (int i = start; i <= end; i++) {

                left = generate(start, i - 1);
                right = generate(i + 1, end);

                for (TreeNode lNode : left) {
                    for (TreeNode rNode : right) {
                        TreeNode node = new TreeNode();
                        node.val = i;
                        node.left = lNode;
                        node.right = rNode;
                        list.add(node);
                    }
                }
            }
            return list;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        List<TreeNode> trees = solution.generateTrees(0);
        System.out.println("level order ");
        for (TreeNode node : trees) {
            Utils.printTreePre(node);
            System.out.println();
        }
    }
}
