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
            StringBuilder sb = new StringBuilder();

            final int y = x;
            if(x < Integer.MIN_VALUE + 1) {
                x = Integer.MIN_VALUE + 1;
            }
            if(x < 0) {
                x = -x;
            }
            while (x > 0) {
                int g = x % 10;
                x /= 10;
                sb.append(g);
            }
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if(y < 0 && sb.length() > 0) {
                int f = sb.charAt(0) - '0';
                sb.deleteCharAt(0);
                sb.insert(0, -f);
            }
            String result = sb.toString();
            if(result.length() == 0 || (y > 0 && Long.valueOf(result) > Integer.MAX_VALUE) ||
                    (y < 0 && Long.valueOf(result) < Integer.MIN_VALUE)) {
                return 0;
            }
            return Integer.parseInt(result);
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
