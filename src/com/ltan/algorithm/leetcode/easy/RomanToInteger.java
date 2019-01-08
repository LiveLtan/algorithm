package com.ltan.algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * Detail: from Leetcode 13
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
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
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 *
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Added by ltan on 2019/1/8
 */
public class RomanToInteger {
    static class Solution {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanNumber = new HashMap<>();
        initMap(romanNumber);
        char[] nums = s.toCharArray();
        if(nums.length <= 1) {
            return romanNumber.get(nums[0]);
        }
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            if(i >= nums.length - 1) {
                res += (romanNumber.get(nums[i]));
                break;
            }
            if(i >= nums.length - 2) {
                res += handleSpecial(nums[i], nums[i + 1], romanNumber);
                break;
            }
            //res += (handleSpecial(nums[i], nums[i + 1], romanNumber));
            res += (handleSpecial(nums[i], nums[i + 1], nums[i + 2], romanNumber));
            i += 2;
        }
        return res;
    }

    private void initMap(HashMap<Character, Integer> romanNumber) {
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);
    }

    private int handleSpecial(char f, char b, HashMap<Character, Integer> map) {
        if(f == b) {
            return 2 * map.get(f);
        }
        if(f == 'I' || f == 'X' || f == 'C') {
            return map.get(b) - map.get(f);
        }
        if(f == 'V' || f == 'L' || f == 'D' || f == 'M') {
            return map.get(f) + map.get(b);
        }
        return 0;
    }

    private int handleSpecial(char f, char m, char b, HashMap<Character, Integer> map) {
        if (f == m && m == b) {
            return map.get(f) * 3;
        }
        if ((m == 'C' && (b == 'D' || b == 'M'))
        || (m == 'X' && (b == 'L' || b == 'C' || b == 'D' || b == 'M' ))) {
            return map.get(f) + map.get(b) - map.get(m);
        }
        return 0;
    }
    }

    public static void run() {
        System.out.println(new Solution().romanToInt("MDXI"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("MCMXCV"));
    }
}
