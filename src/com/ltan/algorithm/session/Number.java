package com.ltan.algorithm.session;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public class Number {
    public static void main(String[] args) {
        System.out.println("please in put an array");
        //int[] arrays = new int[] {2, 7, 11, 5};
        int[] arrays = new int[] {2, 7, 11, 5, 20};
        int[] result;
        Number numberTest = new Number();
        numberTest.getIndex(arrays, 9);
        numberTest.getIndex(arrays, 16);
        numberTest.getIndex(arrays, 12);
        numberTest.getIndex(arrays, 20);

        result = numberTest.getIndex2(arrays, 9);
        result = numberTest.getIndex2(arrays, 16);
        result = numberTest.getIndex2(arrays, 12);
        printArray(result);
    }

    private int[] getIndex(int[] targetArrays, int targetNumber) {
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

    private int[] getIndex2(int[] targetArrays, int targetNumber) {
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

    @NotNull
    private static void printArray( int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            //System.out.println("index1=" + result[0] + ", index2=" + result[1]);
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
        }
        System.out.println("]");
    }
}
