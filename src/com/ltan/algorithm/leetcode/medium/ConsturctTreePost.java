package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 106
 * <p>
 * Created by tanlin on 2020-10-23
 */
public class ConsturctTreePost {
    private static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] inorder, int[] postorder, int pStart, int pEnd, int inStart, int inEnd) {

            if (pStart > pEnd || inStart > inEnd) {
                return null;
            }

            int rootVal = postorder[pEnd];
            int rIndex = findRoot(inorder, inStart, inEnd, rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left = helper(inorder, postorder, pStart, pStart + rIndex - inStart - 1, inStart, rIndex - 1);
            root.right = helper(inorder, postorder, pStart + rIndex - inStart, pEnd - 1, rIndex + 1, inEnd);
            return root;
        }

        private int findRoot(int[] inorder, int inStart, int inEnd, int value) {
            int rIndex = 0;
            for (int j = inStart; j <= inEnd; j++) {
                if (inorder[j] == value) {
                    rIndex = j;
                    break;
                }
            }
            return rIndex;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] postValues = new int[]{2, 5, 9, 7, 15, 20, 3};
        int[] inValues = new int[]{2, 9, 5, 3, 7, 20, 15};
        Utils.printTreePre(solution.buildTree(inValues, postValues));
    }
}
