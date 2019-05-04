package com.ltan.algorithm.leetcode.easy;

/**
 * Details: from leetcode 58
 * see 165. Compare Version Numbers. Medium
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 * created by ltan on 2019-01-27
 */
public class LastWordLen {
    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.trim().length() == 0) {
                return 0;
            }
            String[] array = s.split(" ");
            return array[array.length - 1].length();
        }
    }

    public static void run() {
        Solution s = new Solution();
        //int r = s.lengthOfLastWord("hello world");
        int r = s.lengthOfLastWord("");
        System.out.println("result:" + r);
    }
}