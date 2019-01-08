package com.ltan.algorithm.leetcode.easy;

import java.util.ArrayList;

/**
 * Detail: From Leetcode 9
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
 * <p>
 * Added by ltan on 2019/1/7
 */
public class PalindromeInteger {
    static class Solution {

        /**
         * optimise for {@link #isPalindrome2(int)}
         *
         * @return true if if palindrome number
         */
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            int revert = 0;
            while (x > revert) {
                revert = revert * 10 + x % 10;
                x /= 10;
            }
            return x == revert || x == revert / 10;
        }

        /**
         * optimise for {@link #isPalindrome3(int)}
         *
         * @return true if if palindrome number
         */
        public boolean isPalindrome2(int x) {
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            // use int array, length max 10: (2^31-1)=2,147,483,647
            int[] numbers = new int[10];
            int c = 0;
            while (x != 0) {
                numbers[c++] = x % 10;
                x /= 10;
            }
            for (int i = 0; i < c / 2; i++) {
                if (numbers[i] == numbers[c - i - 1]) {
                    continue;
                }
                return false;
            }
            return true;
        }

        /**
         * judge whether the x is palindrome or not.
         *
         * @param x input number
         * @return true if if palindrome number
         */
        public boolean isPalindrome3(int x) {
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            // use int array list
            ArrayList<Integer> numbers = new ArrayList<>();
            while (x != 0) {
                numbers.add(x % 10);
                x /= 10;
            }
            int count = numbers.size();
            for (int i = 0; i <= count / 2; i++) {
                if (numbers.get(i).equals(numbers.get(count - i - 1))) {
                    continue;
                }
                return false;
            }
            return true;
        }
    }

    public static void run() {
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(1));
        System.out.println(new Solution().isPalindrome(11));
        System.out.println(new Solution().isPalindrome(10101));
        System.out.println(new Solution().isPalindrome(102301));
    }
}
