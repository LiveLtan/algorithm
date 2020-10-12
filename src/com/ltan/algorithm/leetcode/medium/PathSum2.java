package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Detail: from Leetcode 113
 * <p>
 * Created by tanlin on 2020-10-30
 */
public class PathSum2 {
    static class Solution {
        public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> result  = new LinkedList<>();
            List<Integer> currentResult  = new LinkedList<>();
            pathSum(root,sum,currentResult,result);
            return result;
        }

        /**
         * ref: https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution
         */
        public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
                            List<List<Integer>> result) {

            if (root == null) {
                return;
            }
            currentResult.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                result.add(new LinkedList<>(currentResult));
                // currentResult.remove(currentResult.size() - 1);
                // return;
            } else {
                pathSum(root.left, sum - root.val, currentResult, result);
                pathSum(root.right, sum - root.val, currentResult, result);
            }
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public static void run() {
        Solution solution = new Solution();
        // int[] nums = new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1};
        // int[] nums = new int[]{5, 4, 8, 11, -1, 9, 4, 7, 2, -1, -1, 0, -1, 5, 1};
        int[] nums = new int[]{5, 4, 8, 11, -1, 7, 4, 7, 2, -1, -1, 2, -1, 5, 1};
        // int[] nums = new int[]{2, -1, 3, -1, 4, -1, 5, -1, 6};
        // int[] nums = new int[]{1, 2, -1, 4, 5, 6, -1, 8};
        TreeNode root = Utils.generateTreeNode(nums);
        Utils.checkTree(root);
        System.out.println(solution.hasPathSum(root, 22));
    }
}