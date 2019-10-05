package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Detail: from Now Coder find least K numbers
 * <p>
 * Created by tanlin on 2019-10-05
 */
public class LeastKNumbers {

    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        LinkedList<Integer> mins = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            inputValue(mins, input[i], k);
        }
        return new ArrayList<>(mins);
    }

    private void inputValue(LinkedList<Integer> mins, int value, int k) {
        if (k > 0 && mins.isEmpty()) {
            mins.offer(value);
            return;
        }
        insertSort(mins, value, k);
    }

    private void insertSort(LinkedList<Integer> mins, int value, int k) {
        int size = mins.size();
        int i = 0;
        for (; i < size; i++) {
            int v = mins.get(i);
            if (value <= v) {
                if (size >= k) {
                    mins.pollLast();
                }
                mins.add(i, value);
                break;
            } else if (size >= k && value >= mins.peekLast()) {
                break;
            }
        }
        if (i == size && size < k) {
            mins.addLast(value);
        }
    }

    public static void run() {
        LeastKNumbers target = new LeastKNumbers();
        int[] nums = Utils.generateArrayByString("[4,5,1,6,2,7,3,8]");
        // ArrayList<Integer> rst = target.getLeastNumbers(nums, 0);
        ArrayList<Integer> rst = target.getLeastNumbers(nums, 4);
        // ArrayList<Integer> rst = target.getLeastNumbers(nums, 10);
        System.out.println("rst :" + rst);
    }
}