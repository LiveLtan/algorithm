package com.ltan.algorithm.leetcode.easy;

import java.util.HashMap;

/**
 * Detail: From leetcode 20
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * <p>
 * Added by ltan on 2019/1/10
 */
public class ParenthesesValid {
    static class Solution {
        public boolean isValid(String s) {
            if (s.length() == 0 || s.trim().length() == 0) {
                return true;
            }
            if (s.length() < 2) {
                return false;
            }
            HashMap<Character, Character> opMap = new HashMap<>();
            opMap.put(')', '(');
            opMap.put(']', '[');
            opMap.put('}', '{');
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                int last = sb.length() - 1;
                if (!opMap.containsKey(c)
                        || last < 0
                        || sb.charAt(last) != opMap.get(c)) {
                    sb.append(c);
                    continue;
                }
                if (sb.charAt(last) == opMap.get(c)) {
                    sb.deleteCharAt(last);
                }
            }
            return sb.length() == 0;
        }
    }

    public static void run() {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("([){}]"));
        System.out.println(s.isValid("([]{[}])"));
        System.out.println(s.isValid("  "));
    }
}