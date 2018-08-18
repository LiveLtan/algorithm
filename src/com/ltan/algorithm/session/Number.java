package com.ltan.algorithm.session;

import java.util.HashMap;

/**
 * From Leetcode 1
 *
 * Given an array of integers, find out two numbers such that they add up
 * to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that
 * add up to the target, where index1 must be less than index2, Please note
 * that your returned answer (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Tags: Array, HashTable
 */
public class Number {

    public static void main(String[] args) {
        System.out.println("please in put an array");
        //int[] arrays = new int[] {2, 7, 11, 5};
        int[] arrays = new int[] {2, 7, 11, 5, 20};
        int[] result;
        Number numberTest = new Number();
        numberTest.twoSum(arrays, 9);
        numberTest.twoSum(arrays, 16);
        numberTest.twoSum(arrays, 12);
        numberTest.twoSum(arrays, 20);

        result = numberTest.twoSum2(arrays, 9);
        result = numberTest.twoSum2(arrays, 16);
        result = numberTest.twoSum2(arrays, 12);
        printArray(result);
    }

    /**
     * get the two sub numbers' index
     * O(n^2) complexity
     *
     * @param targetArrays data array
     * @param targetNumber target number
     * @return index array, contains two index or NULL if not found.
     */
    private int[] twoSum(int[] targetArrays, int targetNumber) {
        if(targetArrays == null || targetArrays.length == 0) {
            return null;
        }
        for(int i = 0; i < targetArrays.length - 1; i++) {
            for(int j = i + 1; j < targetArrays.length; j++) {
                if(targetArrays[i] + targetArrays[j] == targetNumber) {
                    return new int[]{(i +1), (j + 1)};
                }
            }
        }
        return null;
    }

    /**
     * get the two sub numbers' index
     * O(n) space, O(n) complexity
     *
     * @param targetArrays data array
     * @param targetNumber target number
     * @return index array, contains two index or NULL if not found.
     */
    private int[] twoSum2(int[] targetArrays, int targetNumber) {
        if(targetArrays == null || targetArrays.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> arraysMap = new HashMap<>(targetArrays.length);
        for(int i = 0; i < targetArrays.length; i++) {
            arraysMap.put(targetArrays[i], i);
        }

        for(int i = 0; i < targetArrays.length - 1; i++) {
            int subValue = targetNumber - targetArrays[i];
            if(arraysMap.containsKey(subValue) && i != arraysMap.get(subValue)) {
                return new int[]{(i +1), (arraysMap.get(subValue) + 1)};
            }
        }
        return null;
    }

    /**
     * print the all members, like "[,,,]"
     * @param array target array
     */
    private static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
        }
        System.out.println("]");
    }
}
