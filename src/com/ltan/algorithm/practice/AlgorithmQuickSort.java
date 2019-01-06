package com.ltan.algorithm.practice;

/**
 * Detail:
 * quick sort from small to large by recursive
 * <p>
 * Added by ltan on 2018/9/6
 */
public class AlgorithmQuickSort {

    /**
     *
     * @param nums  integers array
     * @param start start index, from 0
     * @param end   end index, less than arrays' length
     */
    public void quickSort(int[] nums, int start, int end) {
        // validate check
        if(start < 0 || start > end || end > nums.length - 1) {
            return;
        }
        if(start == end) { // Only one element, just return
            return;
        }
        // Algorithm core
        int i = start + 1, j = end, k = start;
        int flag = nums[start];
        while (i <= j) {
            if(flag <= nums[j]) {
                j--;
                continue;
            }
            nums[k] = nums[j];
            k = j;
            if(flag > nums[i]) {
                i++;
                continue;
            }
            nums[k] = nums[i];
            k = i;
            j--;
        }
        // the last empty box will put into the flag
        nums[k] = flag;

        // sort the flag left and right elements
        quickSort(nums, start, k - 1);
        quickSort(nums, k + 1, end);
    }
}
