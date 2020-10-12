package com.ltan.algorithm.leetcode.easy;

public class SqrtX {
    static class Solution {
        public int mySqrt(int x) {
            return (int) Math.sqrt(x);
        }
    }

    public static void run() {
        int x = 10;
        System.out.println("result = " + new Solution().mySqrt(x));
    }
}
