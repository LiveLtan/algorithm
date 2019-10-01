package com.ltan.algorithm.offer;

/**
 * Detail: from For-offer
 * <p>
 * Created by tanlin on 2019-10-01
 */
public class Power {

    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static void run() {
        Power power = new Power();
        double rst = power.Power(8.4d, 3);
        System.out.println("rst:" + rst);
    }
}
