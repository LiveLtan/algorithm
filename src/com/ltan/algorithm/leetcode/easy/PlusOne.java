package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from Leetcode 66
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Created by tanlin on 2019-04-03
 */
public class PlusOne {
    static class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null) {
                return null;
            }
            int[] ret = digits;
            boolean c = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                c = false;
                digits[i] += 1;
                if (digits[i] > 9) {
                    c = true;
                    digits[i] = 0;
                }
                if (!c) {
                    break;
                }
            }
            if (c) {
                ret = new int[digits.length + 1];
                // system array copy
                System.arraycopy(digits, 0, ret, 1, digits.length);
                ret[0] = 1;
            }
            return ret;
        }
    }
    public static void run() {
        Solution s = new Solution();
        String arrayStr = "[7,9,1,9]";
        int[] array = Utils.generateArrayByString(arrayStr);
        Utils.printArray(array);
        int[] r = s.plusOne(array);
        Utils.printArray(r);
    }
}