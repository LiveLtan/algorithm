package com.ltan.algorithm.leetcode.easy;

public class ReverseInteger {
    static class Solution {
        /**
         * upload to leetcode, but 36ms, > 11%
         * should be optimised
         * @param x target number
         * @return the reversed number
         */
        public int reverse(int x) {
            long result = 0;
            while (x != 0) {
                int g = x % 10;
                x /= 10;
                result = result * 10 + g;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    return 0;
                }
            }
            return (int)result;
        }
    }

    public static void run() {
        //int result = new Solution().reverse(6927694924);
        //int result = new Solution().reverse(2147483412);
        int result = new Solution().reverse(-1900);
        //int result = new Solution().reverse(-2147483648);
        //int result = new Solution().reverse(-2147483412);
        System.out.println(result);
    }
}
