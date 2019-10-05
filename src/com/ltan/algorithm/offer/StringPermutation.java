package com.ltan.algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Detail: from For-offer string permutation
 * <p>
 * Created by tanlin on 2019-10-05
 */
public class StringPermutation {
    private ArrayList<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        permute(str.toCharArray(), 0);
        // sort： cba -> cab
        Collections.sort(res);
        return res;
    }

    private void permute(char[] chs, int begin) {
        int len = chs.length;
        if (begin == len) {
            sb.append(chs);
            String str = sb.toString();
            // https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?f=discussion
            // if (!res.contains(str)) {
            // }
            res.add(str);
            sb.setLength(0);
            return;
        }
        for (int i = begin; i < len; i++) {
            // https://www.cnblogs.com/cxjchen/p/3932949.html
            if (shouldSwipe(chs, begin, i)) {
                swap(chs, i, begin);
                permute(chs, begin + 1);
                swap(chs, i, begin);
            }
        }
    }

    private void swap(char[] chs, int i, int j) {
        if (i == j
                || i < 0 || i > chs.length - 1
                || j < 0 || j > chs.length - 1) {
            return;
        }
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    private boolean shouldSwipe(char[] chs, int begin, int end) {
        boolean should = true;
        for (int i = begin; i < end; i++) {
            if (chs[i] == chs[end]) {
                should = false;
                break;
            }
        }
        return should;
    }

    public static void run() {
        StringPermutation permutation = new StringPermutation();
        ArrayList<String> rst = permutation.permutation("abc");
        System.out.println("rst :" + rst);
    }
}
