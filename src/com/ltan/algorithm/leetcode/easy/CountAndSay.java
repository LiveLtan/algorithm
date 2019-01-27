package com.ltan.algorithm.leetcode.easy;

/**
 * Details: from leetcode 38
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * Example 1:
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * Input: 4
 * Output: "1211"
 * <p>
 * created by ltan on 2019-01-24
 */
public class CountAndSay {
    static class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            if (n == 2) {
                return "11";
            }
            String last = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            int index3;// = last.indexOf('3');

            do {
                index3 = last.indexOf('3');
                if (index3 >= 0) {
                    String sub = last.substring(0, index3);
                    sb.append(spit(sub));

                    int len = sb.length();
                    if (index3 == 0 && len > 2) {
                        char c = (char)(sb.charAt(len - 2) + '1' - '0');
                        sb.setCharAt(len - 2, c);
                    } else {
                        sb.append('1').append('3');
                    }
                    last = last.substring(index3 + 1);
                } else {
                    sb.append(spit(last));
                    break;
                }
            } while (true);
            return sb.toString();
        }

        private String spit(String s) {
            if (s.length() == 0) {
                return "";
            }
            int index2 = s.indexOf('2');
            StringBuilder sb = new StringBuilder();
            if (index2 < 0) {           // 1+
                sb.append(s.length()).append('1');
            } else if (index2 == 0) {   // 2+ 1
                int index1 = s.indexOf('1');
                if (index1 < 0) {
                    sb.append(s.length()).append('2');
                } else {
                    sb.append(index1).append('2');
                    sb.append(spit(s.substring(index1)));
                }
            } else {                    // 1+ 2+
                sb.append(index2).append('1');
                sb.append(spit(s.substring(index2)));
            }
            return sb.toString();
        }
    }

    public static void run() {
        Solution s = new Solution();
        //System.out.println(s.countAndSay(3));//21
        //System.out.println(s.countAndSay(4));//1211
        //System.out.println(s.countAndSay(5));//111221
        //System.out.println(s.countAndSay(6));//312211
        //                                       //312211
        //System.out.println(s.countAndSay(7));//13112221
        //                                       //13112221
        //System.out.println(s.countAndSay(8));//1113213211
        //                                       //1113213211
        //System.out.println(s.countAndSay(9));//31131211131221
        //                                       //31131211131221
        //System.out.println(s.countAndSay(10));//13211311123113112211
        //                                       //13211311123113112211

        //System.out.println(s.countAndSay(11));//11131221133112132113212221
        //                                       //11131221133112132113212221

        //System.out.println(s.countAndSay(12));//3113112221232112111312211312113211
        //                                        //311311222 1232112 111312211 31211 3211

        System.out.println(s.countAndSay( 13));//1321132132 111213122112 3113112221 13111221 131221
        //                                        //1321132132 111213122112 3113112221 13111221 131221

    }
}