package com.ltan.algorithm.leetcode;
//

import com.ltan.algorithm.utils.Utils;

/**
 * From Leetcode 283
 * similar problems number: 27 26
 *
 * Given an nums numbers, write a function to move all 0's to the end of
 * it while maintaining the relative order of the non-zero elements.
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Tags: nums
 */
public class AlgorithmMoveZeros {

    public void moveZeros(int[] nums) {
        if(Utils.emptyArray(nums)) {
            return;
        }
        // indicate the current zero index
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            // let the two index swap, unnecessary work if all number is non-zero
            Utils.swap(nums, flag++, i);
        }
    }

    /**
     * Optimise for moveZeros, if flag is equal with current index,
     * means member and flag are non-zero, to find the next index.
     * @param nums target integer array
     */
    public void moveZeros2(int[] nums) {
        if(Utils.emptyArray(nums)) {
            return;
        }
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            // if current flag is the same as loop index,
            // just move flag to the next one.
            if(i == flag) {
                flag++;
                continue;
            }
            Utils.swap(nums, flag++, i);
        }
    }

    /**
     * Optimise for moveZeros2
     * if flag is zero, let the flag's to save the i index's value.
     * directly assign value the cur index to 0
     *
     * @param nums target integer array
     */
    public void moveZeros3(int[] nums) {
        if(Utils.emptyArray(nums)) {
            return;
        }
        // indicate the current zero index
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            // fond the non-zero index, if the flag index is non-zero
            // move flag to the next one
            if(nums[flag] != 0) {
                flag++;
                continue;
            }
            // now, the flag index is zero, do simple assign value.
            nums[flag++] = nums[i];
            nums[i] = 0;
        }
    }

}
