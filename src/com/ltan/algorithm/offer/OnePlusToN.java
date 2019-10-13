package com.ltan.algorithm.offer;

/**
 * Detail: from Now Coder
 * <p>
 * Created by tanlin on 2019-10-13
 */
public class OnePlusToN {

    public int sum(int n) {
        int sum = n;
        boolean f = sum > 0 && (sum += sum(n - 1)) > 0;
        return sum;
    }

    public int sum2(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    /**
     * https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1?f=discussion
     *
     * @return
     */
    public int sum3Helper(int n) {
        int res = 0;
        int a = n;//若a=2=10
        int b = n + 1;//b=3=11
        while (a != 0) {
            //a在第二位==1的时候才更新res=0+110=6
            if ((a & 1) == 1) {
                res += b;
            }
            a >>= 1;//a右移1位 1
            b <<= 1;//b左移动1位 110
        }
        return res >>= 1;//n(n+1)/2
    }

    /**
     * the last res nees to divide by 2, right move 1 bit.
     */
    public int sum3(int n) {
        int result = sum3(n, n + 1);
        return result >> 1;
    }
    private int sum3(int a, int b) {
        int res = 0;
        //循环体内部, if ((a & 1) == 1), res += b;
        boolean flag1 = ((a & 1) == 1) && (res += b) > 0;
        a >>= 1;
        b <<= 1;
        // while (a != 0) {}循环条件
        boolean flag2 = (a != 0) && (res += sum3(a, b)) > 0;
        return res;
    }

    public static void run() {
        OnePlusToN target = new OnePlusToN();
        // int rst = target.sum(100);
        int rst = target.sum3(100);
        System.out.println("rst :" + rst);
    }
}