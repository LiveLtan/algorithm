package com.ltan.algorithm.leetcode.medium;

/**
 * Detail: from Leetcode 96
 * <p>
 * Created by tanlin on 2020-10-14
 */
public class UniqueBinaryTree {
    static class Solution {
        public int numTrees(int n) {
            if (n < 1) {
                return 0;
            }
            // return numTrees2(n);
            return numTrees(1, n);
        }

        private int numTrees(int l, int r) {
            if (l >= r) return 1;

            int res = 0;
            for (int root = l; root <= r; ++root) {
                res += numTrees(l, root - 1) * numTrees(root + 1, r);
            }
            return res;
        }

        // Awesome!! Ref: https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/
        private int numTrees2(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }

    public static void run() {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(5));
    }
}
