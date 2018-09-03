package com.ltan.algorithm.practice;

/**
 * Detail: sort an array by insert
 * <p>
 * keep the original sequence when two element are equals
 * Added by ltan on 2018/9/4
 */
public class AlgorithmSortByInsert {
    public void sort(int[] nums) {
        int length = nums.length;
        // beginning of the second element, find the next suitable index
        for(int currentIndex = 1; currentIndex < length; currentIndex++) {
            // if less than previous item, move it
            if(nums[currentIndex] < nums[currentIndex - 1]) {
                moveItems(currentIndex, nums[currentIndex], nums);
            }
        }
    }

    private void moveItems(int index, int num, int[] nums) {
        int tmp = nums[index];
        int i = index;
        for(; i > 0; i--) {
            nums[i] = nums[i - 1];
            if(num > nums[i]) {
                nums[i] = tmp;
                break;
            }
        }
        if(i == 0 && num < nums[0]) {
            nums[0] = tmp;
        }
    }

    private void moveItems2(int index, int num, int[] nums) {
        int tmp = nums[index];
        int i = index;
        for(; i > 0; i--) {
            // stability sort
            if(num == nums[i - 1]) {
                nums[i] = tmp;
                break;
            }
            nums[i] = nums[i - 1];
            if(num > nums[i]) {
                nums[i] = tmp;
                break;
            }
        }
        if(i == 0 && num < nums[0]) {
            nums[0] = tmp;
        }
    }
}
