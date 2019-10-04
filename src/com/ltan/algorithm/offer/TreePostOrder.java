package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from For-offer binary search tree by post-order
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class TreePostOrder {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBst(sequence, 0, sequence.length - 1);
    }

    private boolean isBst(int[] sequence, int b, int e) {
        if (e <= b) {
            return true;
        }
        int root = sequence[e];
        int rIndex = e;
        for (int i = e; i >= 0; i--) {
            if (sequence[i] > root) {
                rIndex--;
            }
        }

        for (int j = rIndex - 1; j >= b; j--) {
            if (sequence[j] > root) {
                return false;
            }
        }

        boolean l = isBst(sequence, b, rIndex - 1);
        boolean r = isBst(sequence, rIndex, e - 1);
        return l && r;
    }

    public static void run() {
        TreePostOrder postOrder = new TreePostOrder();
        // int[] nums = Utils.generateArrayByString("[1,2,4,3,6,7,9,8,5]");
        int[] nums = Utils.generateArrayByString("[4,8,6,12,16,14,10]");
        // int[] nums = Utils.generateArrayByString("[5,4,3,2,1]");
        // int[] nums = Utils.generateArrayByString("[7,4,6,5]");
        boolean rst = postOrder.verifySequenceOfBST(nums);
        System.out.println("rst:" + rst);
    }
}
