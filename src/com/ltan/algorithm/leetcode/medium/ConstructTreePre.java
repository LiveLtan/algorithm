package com.ltan.algorithm.leetcode.medium;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 105
 * <p>
 * Created by tanlin on 2020-10-20
 */
public class ConstructTreePre {
    private static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return helper(preorder, inorder, 0, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {

            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int rIndex = findRoot(inorder, inStart, inorder.length, root.val);
            root.left = helper(preorder, inorder, preStart + 1, inStart, rIndex - 1);
            root.right = helper(preorder, inorder, preStart + rIndex - inStart + 1, rIndex + 1, inEnd);
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
        int[] preValues = new int[]{3, 9, 2, 5, 20, 7, 15};
        int[] inValues = new int[]{2, 9, 5, 3, 7, 20, 15};
        Utils.printTreePre(solution.buildTree(preValues, inValues));
    }
}
