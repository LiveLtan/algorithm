package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Now Coder max sum of sub array
 * <p>
 * Created by tanlin on 2019-10-05
 */
public class SubArrayGreatestSum {

    /**
     * none Recursion
     * @param array
     * @return
     */
    public int findGreatestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            int cValue = array[i];
            if (curSum <= 0) {
                curSum = cValue;
            } else {
                curSum += cValue;
            }
            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    /**
     * https://www.nowcoder.com/questionTerminal/459bd355da1549fa8a49e350bf3df484?f=discussion
     *
     * Recursion
     *
     * @param array nums
     * @return max sum
     */
    public int findGreatestSunRecursion(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int rstMax = array[0];
        int curMax = array[0];
        for (int i = 1; i < array.length; i++) {
            curMax = Math.max(curMax + array[i], array[i]);
            rstMax = Math.max(curMax, rstMax);
        }
        return rstMax;
    }

    public static void run() {
        SubArrayGreatestSum target = new SubArrayGreatestSum();
        // int[] nums = Utils.generateArrayByString("[6,-3,-2,7,-15,1,2,2]"); // 8
        int[] nums = Utils.generateArrayByString("[1,-2,3,10,-4,7,2,-5]"); // 18
        // int rst = target.findGreatestSum(nums);
        int rst = target.findGreatestSunRecursion(nums);
        System.out.println("rst :" + rst);
    }
}