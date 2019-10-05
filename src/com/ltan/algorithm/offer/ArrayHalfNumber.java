package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

import java.util.HashMap;

/**
 * Detail: from For-offer find value, time appear more than half of array
 * <p>
 * Created by tanlin on 2019-10-05
 */
public class ArrayHalfNumber {

    public int moreThanHalfNum(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        if (len == 1) {
            return array[0];
        }
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int v = map.get(i);
                if (v + 1 >= (len / 2 + 1)) {
                    return i;
                }
                map.put(i, v + 1);
            }
        }
        return 0;
    }

    public static void run() {
        ArrayHalfNumber halfNumber = new ArrayHalfNumber();
        // int[] nums = Utils.generateArrayByString("[1,2,3,2,2,2,5,4,2]");
        int[] nums = Utils.generateArrayByString("[1]");
        int rst = halfNumber.moreThanHalfNum(nums);
        System.out.println("rst:" + rst);
    }
}
