package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Detail: from Leetcode
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class BstConvert {
    /**
     * O(n) + S(n)
     * @param pRootOfTree Root of tree
     * @return first node
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (pRootOfTree == null) {
            return null;
        }
        addInto(nodes, pRootOfTree);
        int size = nodes.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode node = nodes.get(i);
            node.right = nodes.get(i + 1);
        }
        if (size > 0) {
            nodes.get(0).left = nodes.get(size - 1);
            nodes.get(size - 1).right = nodes.get(0);
        }
        return size > 0 ? nodes.get(0) : null;
    }

    private void addInto(ArrayList<TreeNode> nodes, TreeNode node) {
        if (node == null) {
            return;
        }
        addInto(nodes, node.left);
        nodes.add(node);
        addInto(nodes, node.right);
    }

    private TreeNode pre = null;
    private TreeNode firstNode = null;

    /**
     * recursion version
     * O(n) + S(1)
     *
     * @param root Root of tree
     * @return first node
     */
    public TreeNode convertPerf(TreeNode root) {
        if (root == null) {
            return null;
        }
        travel(root);
        return firstNode;
    }

    private void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        travel(node.left);
        // node.left = pre;
        if (pre != null) {
            node.left = pre;
            pre.right = node;
        } else {
            firstNode = node;
            pre = firstNode = node;
        }
        pre = node;
        travel(node.right);
        if (node.right == null) {
            node.right = firstNode;
            firstNode.left = node;
        }
    }

    /**
     * https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?f=discussion
     * none recursion version
     * O(n) + S(log n)
     * @param root root node
     * @return first node
     */
    public TreeNode convertPerf2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        TreeNode firstNode = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null) {
                pre = firstNode = p;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return firstNode;
    }

    public static void run() {
        BstConvert bstConvert = new BstConvert();
        int[] nums = Utils.generateArrayByString("[5,3,8,2,4,6,10]");
        TreeNode root = Utils.generateTreeNode(nums);
        // TreeNode rst = bstConvert.convert(root);
        TreeNode rst = bstConvert.convertPerf(root);
        // TreeNode rst = bstConvert.convertPerf2(root);
        System.out.println("node value " + rst.right.val + " " + rst.left.val);
        System.out.println("first node is: " + bstConvert.firstNode == null ? "" : bstConvert.firstNode.right.val);
    }
}
