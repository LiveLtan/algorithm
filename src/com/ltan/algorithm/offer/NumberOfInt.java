package com.ltan.algorithm.offer;

/**
 * Detail: from For-offer
 * get number {@code 1} of the binary sequence
 * <p>
 * Created by tanlin on 2019-10-01
 */
public class NumberOfInt {

    public int NumberOf1(int n) {
        int len = 0;
        for(int i = 0; i < 32; i++) {
            int tmp = n & 0x01;
            if (tmp == 1) {
                len++;
            }
            n = n >> 1;
        }
        return len;
    }

    public static void run() {
        NumberOfInt noi = new NumberOfInt();
        int rst = noi.NumberOf1(-1);
        System.out.println("rst:" + rst);
    }
}
