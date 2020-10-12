package com.ltan.algorithm.leetcode.easy;

public class AddBinary {
    static class Solution {
        public String addBinary(String a, String b) {
            if (a.length() < b.length()) {
                String tmp = b;
                b = a;
                a = tmp;
            }
            char[] arr = a.toCharArray();
            char[] brr = b.toCharArray();
            int bl = b.length() - 1;
            int al = a.length() - 1;
            int c = 0;
            for (int i = 0; i < b.length(); i++) {
                int av = arr[al - i] - 48;
                int bv = brr[bl - i] - 48;
                if (av + bv + c == 2) {
                    arr[al - i] = '0';
                    c = 1;
                } else if (av + bv + c == 3) {
                    arr[al - i] = '1';
                    c = 1;
                } else {
                    arr[al - i] = (char) (av + bv + c + 48);
                    c = 0;
                }
            }

            for (int i = al - bl - 1; i >= 0; i--) {
                int av = arr[i] - 48;
                if (av + c == 2) {
                    arr[i] = '0';
                    c = 1;
                } else if (av + c == 3) {
                    arr[i] = '1';
                    c = 1;
                } else {
                    arr[i] = (char) (av + c + 48);
                    c = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (c > 0) {
                sb.append('1');
            }
            sb.append(arr);
            return sb.toString();
        }

        public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            // sb.insert(0, sum % 2);
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
        }
    }

    public static void run() {
        String a = "1011";
        String b = "1010";
        // String b = "001";
        //         1000
        System.out.println("result = " + new Solution().addBinary(a, b));
        System.out.println("result = " + new Solution().addBinary2(a, b));
    }
}
