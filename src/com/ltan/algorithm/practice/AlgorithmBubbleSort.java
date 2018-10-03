package com.ltan.algorithm.practice;

/**
 * Detail:
 * basic sort algorithm Bubble Sort..
 * <p>
 * Added by ltan on 2018/10/3
 */
public class AlgorithmBubbleSort {

    public void sort(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            for(int j = length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

}
