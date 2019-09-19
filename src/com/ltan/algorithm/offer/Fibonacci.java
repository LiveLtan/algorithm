package com.ltan.algorithm.offer;

/**
 * Detail: from For-offer 07 Fibonacci sequence
 * <p>
 * Created by tanlin on 2019-09-19
 */
public class Fibonacci {
    static long[] data;

    /**
     * the normal way,
     * @param n number
     * @return target value
     */
    public long solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int i = n - 1;
        if (n == 1) {
            data[i] = 1;
            return 1;
        }
        if (n == 2) {
            data[i] = 1;
            return 1;
        }
        return solution(n - 1) +  solution(n - 2);
    }

    /**
     * Performance the normal way, use the Dynamic planning
     * @param n number
     * @return target value
     */
    public long solution2(int n) {
        if (n <= 0) {
            return 0;
        }
        int i = n - 1;
        if (n == 1) {
            data[i] = 1;
            return 1;
        }
        if (n == 2) {
            data[i] = 1;
            return 1;
        }
        if (data[i] == 0) {
            data[i] = solution2(n - 2) + solution2(n - 1);
        }
        return data[i];
    }

    /**
     * Performance the normal way, use the Non-recursive
     * @param n number
     * @return target value
     */
    public long solution3(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int pre = 1;
        int prePre = 1;
        int lastRltN;
        int i = 3;
        while (i <= n) {
            lastRltN = pre;
            pre = (prePre + pre);
            prePre = lastRltN;
            i++;
        }
        return pre;
    }

    public static void run() {
        Fibonacci fibonacci = new Fibonacci();
        int n = 20;
        data = new long[n];
        long res = fibonacci.solution(n);
        // long res = fibonacci.solution2(n);
        // long res = fibonacci.solution3(n);

        System.out.println("the res is:" + res);
    }
}
