package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Detail: from Leetcode
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class TreeBreadth {
    /**
     * ref: discussion
     * @param root tree node
     * @return sequence
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }

        // queue
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                continue;
            }
            integers.add(node.val);
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return integers;
    }

    public static void run() {
        TreeBreadth treeBreadth = new TreeBreadth();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7]");
        TreeNode root = Utils.generateTreeNode(nums);
        ArrayList<Integer> rst = treeBreadth.printFromTopToBottom(root);
        System.out.println("rst :" + rst);
    }
}
