package com.ltan.algorithm.session;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: From Leetcode 27
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * <p/>
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * <p/>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 *
 * Added by ltan on 2018/8/19
 */
public class AlgorithmRemoveElement {

    /**
     * refer to the {@link AlgorithmMoveZeros}
     * @param nums  target array
     * @param val   the value maybe delete
     * @return how many elements left in nums
     */
    public int removeElement(int[] nums, int val) {
        if(Utils.emptyArray(nums)) {
            return -1;
        }
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            }
            if(i == flag || nums[flag] != val) {
                flag++;
                continue;
            }
            Utils.swap(nums, flag++, i);
            //nums[flag++] = nums[i];
            //nums[i] = val;
        }
        return flag;
    }
}
