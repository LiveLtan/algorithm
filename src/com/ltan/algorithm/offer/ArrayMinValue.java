package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from NowCoder
 * find the min value for a array
 * <p>
 * Created by tanlin on 2019-09-30
 */
public class ArrayMinValue {
    /**
     * O(n)
     * @param array numbers
     * @return min value
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Binary-Search
     * O(log n)
     * @param array numbers
     * @param begin start index
     * @param end   end index
     * @return min value for the numbers
     */
    public int minNumberInRotateArray(int[] array, int begin, int end) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int mid = (begin + end) / 2;
        if (mid == begin) {
            return Math.min(array[begin], array[end]);
        }
        int left = minNumberInRotateArray(array, begin, mid);
        int right = minNumberInRotateArray(array, mid, end);
        return Math.min(left, right);
    }

    public static void run() {
        ArrayMinValue amv = new ArrayMinValue();
        int[] nums = Utils.generateArrayByString("[4,5,6,2,3]");
        int rst = amv.minNumberInRotateArray(nums);
        int rst2 = amv.minNumberInRotateArray(nums, 0, nums.length - 1);
        System.out.println("min value:" + rst + ", rst2:" + rst2);
    }
}
