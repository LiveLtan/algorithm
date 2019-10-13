package com.ltan.algorithm.offer;

/**
 * Detail: from Now Coder
 * <p>
 * Created by tanlin on 2019-10-13
 */
public class SumWithBit {

    public int sum(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (carry != 0);
        return sum;
    }

    public static void run() {
        SumWithBit target = new SumWithBit();
        int rst = target.sum(122, 6);
        System.out.println("rst :" + rst);
    }
}