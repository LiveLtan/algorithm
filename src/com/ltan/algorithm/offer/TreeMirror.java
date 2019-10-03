package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from NowCoder tree mirror
 * <p>
 * Created by tanlin on 2019-10-03
 */
public class TreeMirror {
    public void mirror(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    public static void run() {
        TreeMirror treeMirror = new TreeMirror();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7]");
        TreeNode root = Utils.generateTreeNode(nums);
        Utils.printTreePre(root);
        System.out.println();
        treeMirror.mirror(root);
        System.out.println();
        Utils.printTreePre(root);
    }
}
