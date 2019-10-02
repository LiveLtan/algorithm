package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from For-offer split the even numbers
 * <p>
 * Created by tanlin on 2019-10-01
 */
public class ArrayReOrder {

    /**
     * O(n) + S(n)
     * @param array nums
     */
    public void reOrderArray(int[] array) {
        int tmpLen = array.length;
        int[] tmpArray = new int[tmpLen];
        int j = 0;
        for (int i = 0; i < tmpLen; i++) {
            int num = array[i];
            if ((num & 0x01) == 1) {
                tmpArray[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < tmpLen; i++) {
            int num = array[i];
            if ((num & 0x01) == 0) {
                tmpArray[j] = array[i];
                j++;
            }
        }

        for (int i = 0; i < tmpLen; i++) {
            array[i] = tmpArray[i];
        }
    }

    /**
     * O(n) + S(even)
     * @param array nums
     */
    public void reOrderArrayPerf(int[] array) {
        int aLen = array.length;
        int even = 0;
        for (int i = 0; i < aLen; i++) {
            int num = array[i];
            if ((num & 0x01) == 0) {
                even++;
            }
        }
        int[] evenArray = new int[even];
        int j = 0;
        for (int i = 0; i < aLen; i++) {
            int num = array[i];
            if ((num & 0x01) == 0) {
                evenArray[j++] = num;
            } else {
                array[i - j] = num;
            }
        }
        int evenIndex = aLen - even;
        for (int i = evenIndex; i < aLen; i++) {
            array[i] = evenArray[i - evenIndex];
        }
    }

    /**
     * O(n2) + S(1)
     * @param array nums
     */
    public void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >i ; j--) {
                int numB = array[j - 1];
                int num = array[j];
                if ((num & 0x01) == 1 && (numB & 0x01) == 0) {
                    Utils.swap(array, j, j - 1);
                }
            }
        }

    }

    public static void run() {
        ArrayReOrder arrayReOrder = new ArrayReOrder();
        int[] nums = Utils.generateArrayByString("[1,2,3,4,5,6,7,8,9]");
        // arrayReOrder.reOrderArray(nums);
        // arrayReOrder.reOrderArray2(nums);
        arrayReOrder.reOrderArrayPerf(nums);
        Utils.printArray(nums);
    }
}
