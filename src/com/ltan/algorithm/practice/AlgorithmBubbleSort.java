package com.ltan.algorithm.practice;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail:
 * basic sort algorithm Bubble Sort..
 * <p>
 * Added by ltan on 2018/10/3
 */
public class AlgorithmBubbleSort {

    public void sort(int[] nums) {
        int length = nums.length;
        boolean change = true;
        for(int i = 0; i < length && change; i++) {
            change = false;
            for(int j = length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]) {
                    Utils.swap(nums, j, j - 1);
                    change = true;
                }
            }
        }
    }

}
