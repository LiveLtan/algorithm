package com.ltan.algorithm.practice;

/**
 * Detail:
 * basic sort algorithm Select Sort..
 * <p>
 * Added by ltan on 2018/10/3
 */
public class AlgorithmSelectionSort {

    /**
     * used to, will swap item too much time
     * should be sort2
     * @param nums numbers
     */
    public void sort(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = i + 1; j < length; j++) {
                if(nums[j] < nums[i]) {
                    //
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    /**
     * Just select the min value after the soldier, then exch it
     * maybe the right answer
     * @param nums numbers
     */
    public void sort2(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }
}
