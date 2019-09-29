package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from NowCoder
 * Verify the given integer array which is the post-order traversal of a BST
 * <p>
 * Created by tanlin on 2019-09-29
 */
public class BstVerify {
    public boolean verifySequenceOfBST(int[] sequence, int begin, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (begin >= end) {
            return true;
        }
        int root = sequence[end - 1];
        int i = begin;
        for (; i < end; i++) {
            // find the right BST
            if (sequence[i] > root) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // left BST exist
        boolean left = verifySequenceOfBST(sequence, begin, i - 1);
        // right BST exist
        boolean right = verifySequenceOfBST(sequence, i, end - 1);
        return (left && right);
    }


    public static void run() {
        BstVerify bstVerify = new BstVerify();
        int[] nums = Utils.generateArrayByString("[1, 2, 3, 5, 4, 7, 9, 11, 10, 12, 8]");
        boolean rst = bstVerify.verifySequenceOfBST(nums, 0, nums.length);
        System.out.println("the sequence is BST ?" + rst);
    }
}
