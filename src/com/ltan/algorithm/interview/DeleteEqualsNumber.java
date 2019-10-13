package com.ltan.algorithm.interview;

import com.ltan.algorithm.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Detail: from interview
 * Find adjacent neighbors and remove them
 * <p>
 * [1,-1,-1,1,3,2,5] translated to --> [3,2,5]
 * Created by tanlin on 2019-10-13
 */
public class DeleteEqualsNumber {

    public int[] fun(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int v : array) {
            if (queue.isEmpty()) {
                queue.addLast(v);
            } else if (queue.peekLast() == v) {
                queue.pollLast();
            } else {
                queue.addLast(v);
            }
        }
        int[] newArray = new int[queue.size()];
        for (int i = 0; !queue.isEmpty(); i++) {
            newArray[i] = queue.pop();
        }
        return newArray;
    }

    public static void run() {
        DeleteEqualsNumber target = new DeleteEqualsNumber();
        int[] nums = Utils.generateArrayByString("[-1,1,1,-1,3,2,1,2,5,0,100,0]");
        int[] rst = target.fun(nums);
        // int[] nums = Utils.generateArrayByString("[1,-1,-1,1,1,-1,1,3,2,5]");
        // int[] rst = target.fun2(nums);
        Utils.printArray(rst);
    }
}