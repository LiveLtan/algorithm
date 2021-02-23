package com.ltan.algorithm.leetcode.easy;

public class ClimbingStairs {
    static class Solution {
        int[] values = null;

        public int climbStairs(int n) {
            if (values == null) {
                values = new int[46];
                values[0] = 0;
                values[1] = 1;
                values[2] = 2;
                values[3] = 3;
            }
            if (n < 1) {
                return 0;
            }
            if (n <= 3) {
                values[n] = n;
                return n;
            }
            for (int i = 3; i <= n; i++) {
                values[i] = values[i - 1] + values[i - 2];
            }
            return values[n];
        }
    }

    public static void run() {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(45));
    }
}
