package com.ltan.algorithm.leetcode.medium;

/**
 * Detail: from Leetcode 43
 * <p>
 * Created by tanlin on 2019-04-04
 */
public class MultiplyStrings {
    static class Solution {
        /**
         * the good solution (from leetcode)
         * <p>
         * 两数相乘得到的乘积的长度其实正好是两个数字的长度之和，若 num1 长度为m，num2 长度为n，则 num1 x num2 的长度为 m+n
         * 还要明白乘的时候为什么要错位，比如6乘8得到的48为啥要跟6乘9得到的54错位相加，因为8是十位上的数字，其本身相当于80，
         * 所以错开的一位实际上末尾需要补的0。还有一点需要观察出来的就是，num1 和 num2 中任意位置的两个数字相乘，
         * 得到的两位数在最终结果中的位置是确定的，比如 num1 中位置为i的数字乘以 num2 中位置为j的数字，
         * 那么得到的两位数字的位置为 i+j 和 i+j+1，明白了这些后，我们就可以进行错位相加了，累加出最终的结果。
         * <p>
         * 由于我们要从个位上开始相乘，所以从 num1 和 num2 字符串的尾部开始往前遍历，分别提取出对应位置上的字符，
         * 将其转为整型后相乘。然后确定相乘后的两位数所在的位置 p1 和 p2，将乘法结果和对应位置上的已有数相加，
         * 再将结果放到对应位置。记住 leading zeros 要跳过
         */
        public String multiply(String num1, String num2) {
            if (num1 == null || num2 == null ||
                    num1.length() == 0 || num2.length() == 0) {
                return "0";
            }
            int m = num1.length();
            int n = num2.length();
            int[] digits = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j;
                    int p2 = i + j + 1;

                    int sum = mul + digits[p2];
                    digits[p1] += sum / 10;
                    digits[p2] = sum % 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int d : digits) {
                if (!(sb.length() == 0 && d == 0)) {
                    sb.append(d);
                }
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }

        /*
         * the bad one
         * O(n2)
         * to got every bit result, and append to string builder
         */
        public String multiplyBad(String num1, String num2) {
            if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
                return "0";
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int carry, value;
            String resultStr = "";
            StringBuilder sb = new StringBuilder();
            for (int i = num2.length() - 1; i >= 0; i--) {
                // number 1
                int a = num2.charAt(i) - '0';
                carry = 0;
                sb.setLength(0);

                for (int j = num1.length() - 1; j >= 0; j--) {
                    // number 2
                    int b = num1.charAt(j) - '0';
                    int m = a * b + carry;
                    carry = m / 10;
                    value = m % 10;
                    sb.insert(0, value);
                }
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    sb.append(0);
                }
                if (carry > 0) {
                    sb.insert(0, carry);
                }
                resultStr = stringSum(resultStr, sb.toString());
            }
            return resultStr;
        }

        private String stringSum(String s1, String s2) {
            int l1 = s1.length();
            int l2 = s2.length();
            int a, b, c = 0, s;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < Math.min(l1, l2)) {
                i++;
                a = s1.charAt(l1 - i) - '0'; // get the last digit
                b = s2.charAt(l2 - i) - '0'; // get the last digit
                s = a + b + c;
                if (s > 9) {
                    sb.insert(0, s % 10);
                    c = s / 10;
                } else {
                    sb.insert(0, s);
                    c = 0;
                }
            }
            String extra = "";
            if (l1 > l2) {
                // s1 left
                extra = handleExtra(s1.substring(0, l1 - l2), c);
            } else if (l1 < l2) {
                // s2 left
                extra = handleExtra(s2.substring(0, l2 - l1), c);
            } else if (c > 0) {
                sb.insert(0, c);
            }
            sb.insert(0, extra);
            return sb.toString();
        }

        private String handleExtra(String extra, int c) {
            if (c < 1 && extra.length() > 0) {
                return extra;
            }
            int l = extra.length();
            StringBuilder sb = new StringBuilder();
            int a, s;
            while (l-- > 0) {
                a = extra.charAt(l) - '0';
                s = a + c;
                sb.insert(0, s % 10);
                c = s / 10;
            }
            if (c > 0) {
                sb.insert(0, c);
            }
            return sb.toString();
        }
    }

    public static void run() {
        Solution s = new Solution();
        String num1 = "237";
        String num2 = "284";

        String r = s.multiply(num1, num2);
        // String r = s.multiplyBad(num1, num2);
        System.out.println(r);
    }
}