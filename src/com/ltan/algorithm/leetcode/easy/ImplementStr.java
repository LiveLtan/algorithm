package com.ltan.algorithm.leetcode.easy;

/**
 * Details: from leetcode 28
 * see leetcode 214 (Hard)
 * <p>
 * Maybe you should see the KMP Algorithm.
 * <p>
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * created by ltan on 2019-01-19
 */
public class ImplementStr {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0 || needle.trim().length() == 0) {
                return 0;
            }
            return haystack.indexOf(needle);
        }
    }

    public static void run() {
        Solution s = new Solution();
        //int index = s.strStr("hello", "ll");
        int index = s.strStr("aaaaa", "bba");
        System.out.println("index:" + index);
    }
}