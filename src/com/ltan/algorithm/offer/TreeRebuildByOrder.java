package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.TreeNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from For-offer rebuild a binary tree by pre-order and in-order
 *
 * pre order:[1,2,4,7,3,5,6,8]
 * in  order:[4,7,2,1,5,3,8,6]
 *
 * <p>
 * Created by tanlin on 2019-09-30
 */
public class TreeRebuildByOrder {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] in, int pS, int pE, int iS, int iE) {
        int rootVal = pre[pS];
        TreeNode root = new TreeNode(rootVal);
        if (pS == pE) {
            return root;
        }
        int rootIndex = iS;

        for (int i = iS; i <= iE; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == iE && in[rootIndex] != rootVal) {
            throw new IllegalArgumentException("tree error");
        }
        int leftTreeLen = rootIndex - iS;
        int newPE = pS + leftTreeLen;
        if (leftTreeLen > 0) {
            root.left = buildTree(pre, in, pS + 1, newPE, iS, rootIndex - 1);
        }
        if (leftTreeLen < pE - pS) {
            root.right = buildTree(pre, in, newPE + 1, pE, rootIndex + 1, iE);
        }
        return root;
    }



    public static void run() {
        TreeRebuildByOrder trbo = new TreeRebuildByOrder();
        int[] numsPre = Utils.generateArrayByString("[1,2,4,7,3,5,6,8]");
        int[] numsIn = Utils.generateArrayByString("[4,7,2,1,5,3,8,6]");
        TreeNode node = trbo.reConstructBinaryTree(numsPre, numsIn);
        Utils.printTreePre(node);
        System.out.println();
        Utils.printTreeIn(node);
    }
}
