package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;

/**
 * Detail: from For-offer find a path and sum of nodes = target
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class TreePath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ret = findPath(root, target);
        // todo sorted
        for (ArrayList<Integer> item : ret) {
        }
        return ret;
    }

    /**
     * target - root.val - root.left.val == 0
     * https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?f=discussion
     *
     * @param root tree node
     * @param target target number
     * @return all path
     */
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target < 0) {
            popLastNode(list);
            return listAll;
        }
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
            popLastNode(list);
            return listAll;
        }
        findPath(root.left, target);
        findPath(root.right, target);
        popLastNode(list);
        return listAll;
    }

    private void popLastNode(ArrayList<Integer> list) {
        list.remove(list.size() - 1);
    }

    public static void run() {
        TreePath treePath = new TreePath();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7,9,11,13,10,8]");
        TreeNode root = Utils.generateTreeNode(nums);
        ArrayList<ArrayList<Integer>> rst = treePath.findPath(root, 18);
        System.out.println("rst:" + rst);
    }
}
