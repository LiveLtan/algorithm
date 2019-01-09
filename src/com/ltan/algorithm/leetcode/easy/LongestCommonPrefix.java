package com.ltan.algorithm.leetcode.easy;

/**
 * Detail: From leetcode 14
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 * Added by ltan on 2019/1/9
 */
public class LongestCommonPrefix {
    private static class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLen = -1;
        for(String str: strs) {
            if(minLen < 0 || str.length() < minLen) {
                minLen = str.length();
            }
        }
        String target = strs[0];
        int r = -1;
        boolean allEqual = false;
        out:
        for(int i = 0; i < minLen; i++) {
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != target.charAt(i)) {
                    break out;
                }
                r = i;
            }
        }
        if(r > -1) {
            return target.substring(0, r + 1);
        }
        return "";
    }
    }

    public static void run() {
        Solution s = new Solution();
        //System.out.println("r:" + s.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        //System.out.println("r:" + s.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        //System.out.println("r:" + s.longestCommonPrefix(new String[]{"11231", "11321"}));
        System.out.println("r:" + s.longestCommonPrefix(new String[]{"c", "cc", "a"}));
        System.out.println("r:" + s.longestCommonPrefix(new String[]{"aa"}));
    }
}
