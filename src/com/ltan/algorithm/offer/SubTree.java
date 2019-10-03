package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from NowCoder sub tree
 * <p>
 * Created by tanlin on 2019-10-03
 */
public class SubTree {

    /**
     * Boooobby: https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?f=discussion
     *
     * @param root1 tree root
     * @param root2 sub-tree root
     * @return true if tree contains
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean rst = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                rst = equalNode(root1, root2);
            }
            if (!rst) {
                rst = hasSubtree(root1.left, root2);
            }
            if (!rst) {
                rst = hasSubtree(root1.right, root2);
            }
        }
        return rst;
    }

    /**
     * Judge node equal
     *
     * @param node1 treenode
     * @param node2 treenode
     * @return true if node1 contains node2
     */
    private boolean equalNode(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return equalNode(node1.left, node2.left) && equalNode(node1.right, node2.right);
    }

    public static void run() {
        SubTree subTree = new SubTree();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7,8,9]");
        TreeNode root = Utils.generateTreeNode(nums);
        int[] nums2 = Utils.generateArrayByString("[4,8,9]");
        TreeNode root2 = Utils.generateTreeNode(nums2);
        Utils.printTreeIn(root);
        System.out.println();
        Utils.printTreeIn(root2);
        System.out.println();
        boolean rst = subTree.hasSubtree(root, root2);
        System.out.println("rst is:" + rst);
    }
}
