package com.ltan.algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * Detail: from Leetcode 13
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 * <p>
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Added by ltan on 2019/1/8
 */
public class RomanToInteger {
    static class Solution {

        /**
         * Please guaranteed the RomanNumber String is valid
         * or, we can just use the Regression PATTERN to check it.
         * @param s the roman string
         * @return decimal number
         */
        public int romanToInt(String s) {
            int[] romanValues = new int[]{1, 5, 10, 50, 100, 500, 1000};
            char[] nums = s.toCharArray();
            int i = nums.length - 1;
            int res = 0;
            int last = 0;
            int current;
            while (i >= 0) {
                current = romanValues[getIndex(nums[i])];
                if (last > current) {
                    res -= current;
                } else {
                    res += current;
                }
                last = current;
                i--;
            }
            return res;
        }

        /**
         * get the char index of value array {@code #romanNum}
         * @param c
         * @return
         */
        private int getIndex(char c) {
            int index;
            switch (c) {
                case 'I': index = 0;break;
                case 'V': index = 1;break;
                case 'X': index = 2;break;
                case 'L': index = 3;break;
                case 'C': index = 4;break;
                case 'D': index = 5;break;
                case 'M': index = 6;break;
                default : index = 0;break;
            }
            return index;
        }
    }

    public static void run() {
        System.out.println(new Solution().romanToInt("MDXI"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("MCMXCV"));
        System.out.println(new Solution().romanToInt("MCMXCVI"));
    }
}
