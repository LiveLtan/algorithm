package com.ltan.algorithm.offer;

/**
 * Detail: from NowCoder jump floor
 *
 * <p>
 * Created by tanlin on 2019-09-30
 */
public class JumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     *
     * @param target floor steeps
     * @return n ways
     */
    public int jumpFloor(int target) {
        if (target <= 3) {
            return target;
        }

        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int jumpFloor2(int target) {
        if (target <= 3) {
            return target;
        }
        int pre = 3;
        int prePre = 2;
        int i = 3;
        int lastRst;
        while (i < target) {
            lastRst = pre;
            pre += prePre;
            prePre = lastRst;
            i++;
        }
        return pre;
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级... 它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     *
     * @param target floor steeps
     * @return n ways
     */
    public int jumpFloorII(int target) {
        if (target < 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        // return 2 * jumpFloorII(target - 1);
        return 1 << (target - 1);
    }

    public static void run() {
        JumpFloor jf = new JumpFloor();
        // int rst = jf.jumpFloor(4);
        // int rst = jf.jumpFloor2(6);
        int rst = jf.jumpFloorII(7);
        System.out.println("rst:" + rst);
    }
}
