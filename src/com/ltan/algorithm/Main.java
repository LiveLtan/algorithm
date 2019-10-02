package com.ltan.algorithm;

import com.ltan.algorithm.leetcode.*;
import com.ltan.algorithm.leetcode.easy.*;
import com.ltan.algorithm.offer.*;
import com.ltan.algorithm.practice.AlgorithmBubbleSort;
import com.ltan.algorithm.practice.AlgorithmQuickSort;
import com.ltan.algorithm.practice.AlgorithmSelectionSort;
import com.ltan.algorithm.practice.AlgorithmSortByInsert;
import com.ltan.algorithm.utils.Utils;

public class Main {

    public static void main(String[] args) {
        //testTwoSum();/* leetcode 1 */
        //AlgorithmTwoSum.run();/* leetcode 1 version 2 */
        //AddTwoNumbers.run(); /* leetcode 2 */
        //ReverseInteger.run(); /* leetcode 7 */
        //PalindromeInteger.run(); /* leetcode 9 */
        //RomanToInteger.run(); /* leetcode 13 */
        //LongestCommonPrefix.run(); /* leetcode 14 */
        //ParenthesesValid.run(); /* leetcode 20 */
        //MergeSortedList.run(); /* leetcode 20 */
        //ArrayDuplicatesRemove.run(); /* leetcode 26 */
        //RemoveArrayElement.run(); /* leetcode 27 */
        //ImplementStr.run(); /* leetcode 28 */
        //SearchInsert.run(); /* leetcode 35 */
        //FirstBadVersion.run(); /* leetcode 278 */
        //FirstLastSearch.run(); /* leetcode 34 */
        //CountAndSay.run(); /* leetcode 38 */
        //MaximumSubArray.run(); /* leetcode 53 */
//        PlusOne.run(); /* leetcode 66 */
//        LastWordLen.run(); /* leetcode 58 */

        // medium
        // MultiplyStrings.run(); /* leetcode 43 */

        //testMoveZeros(); /* leetcode 283 */
        //testRemoveElements(); /* leetcode 27 */
        //testBullsCrows(); /* leetcode 299 */

        // test
        //testInsertSort();
        //testQuickSort();
        //testSelectionSort();
        //testBubbleSort();

        // For-offer
        // Fibonacci.run();
        // BstVerify.run();
        // SpaceReplace.run();
        // LinkListReverse.run();
        // TreeRebuildByOrder.run();
        // StackToQueue.run();
        // ArrayMinValue.run();
        // JumpFloor.run();
        // NumberOfInt.run();
        // ArrayReOrder.run();
        LinkLastK.run();
    }

    private static void testTwoSum() {
        System.out.println("please in put an array");
        //int[] arrays = new int[] {2, 7, 11, 5};
        int[] arrays = new int[] {2, 7, 11, 5, 20};
        int[] result;
        AlgorithmTwoSum twoSumTest = new AlgorithmTwoSum();
        twoSumTest.twoSum(arrays, 9);
        twoSumTest.twoSum(arrays, 16);
        twoSumTest.twoSum(arrays, 12);
        twoSumTest.twoSum(arrays, 20);

        result = twoSumTest.twoSum2(arrays, 9);
        result = twoSumTest.twoSum2(arrays, 16);
        result = twoSumTest.twoSum2(arrays, 12);
        printArray(result);
    }

    private static void testMoveZeros() {
        AlgorithmMoveZeros moveZeros = new AlgorithmMoveZeros();
        int[] array = new int[]{0, 3, 2, 29, 0, 1};
        int[] array2 = new int[]{2, -1, 3, 2, 29, 10, 1};
        int[] array3 = new int[]{2, 0, 3, 2, 20, 30, -2, 10, 1};
        moveZeros.moveZeros(array);
        printArray(array);
        moveZeros.moveZeros(array2);
        printArray(array2);
        System.out.println("-------moveZeros2-------");
        moveZeros.moveZeros2(array);
        printArray(array);
        moveZeros.moveZeros2(array2);
        printArray(array2);

        System.out.println("-------moveZeros3--------");
        moveZeros.moveZeros3(array3);
        printArray(array3);
    }

    private static void testRemoveElements() {
        AlgorithmRemoveElement removeElement = new AlgorithmRemoveElement();

        int[] nums = Utils.generateArrayByString("[3,2,2,3]");
        int elementLeftNum = removeElement.removeElement(nums, 2);
        Utils.printArray(nums, elementLeftNum);

        nums = Utils.generateArrayByString("[3,2,2,3,4,]");
        elementLeftNum = removeElement.removeElement(nums, 3);
        Utils.printArray(nums, elementLeftNum);

        nums = Utils.generateArrayByString("[0,1,2,2,3,0,4,2]");
        elementLeftNum = removeElement.removeElement(nums, 2);
        Utils.printArray(nums, elementLeftNum);

        nums = Utils.generateArrayByString("[0,1,2,2,3,0,4,2,100]");
        elementLeftNum = removeElement.removeElement(nums, 0);
        Utils.printArray(nums, elementLeftNum);
    }

    private static void testBullsCrows() {
        AlgorithmBullsCrows bullsCrows = new AlgorithmBullsCrows();
        //final String sec = "1807", guess = "7810";
        //final String sec = "1123", guess = "0111";
        //final String sec = "1123", guess = "1111";
        //final String sec = "1023", guess = "1111";
        //final String sec = "1101", guess = "0110";
        // be careful
        final String sec = "1122", guess = "1222";

        String result = bullsCrows.getHint(sec, guess);
        //result = bullsCrows.getHint2(sec, guess);
        //result = bullsCrows.getHint3(sec, guess);
        System.out.println("testBullsCrows:\n" + result);
    }

    private static void testInsertSort() {
        int[] arrays = new int[] {2, 7, 11, 3, 5, 1, 4, 16, 13, 3, 12, 6, 9, 20};
        AlgorithmSortByInsert algorithmSortByInsert = new AlgorithmSortByInsert();
        algorithmSortByInsert.sort(arrays);
        printArray(arrays);
    }

    private static void testQuickSort() {
        //int[] arrays = new int[] {3, 7, 11, 2, 5, 1, 4/*, 16, 13, 3, 12, 6, 9, 20*/};
        int[] arrays = new int[] {1, 2, 3, 4, 16, 13, 3, 12, 6, 9, 20};
        //int[] arrays = new int[] {1, 2, 3, 4, 16, 13};
        AlgorithmQuickSort algorithmSortByInsert = new AlgorithmQuickSort();
        printArray(arrays);
        algorithmSortByInsert.quickSort(arrays, 0 , arrays.length - 1);
        printArray(arrays);
    }

    private static void testSelectionSort() {
        int[] arrays = new int[] {2, 7, 11, 3, 5, 1, 4, 16, 13, 3, 12, 6, 9, 20};
        AlgorithmSelectionSort algorithmSelectionSort = new AlgorithmSelectionSort();
        //algorithmSelectionSort.sort(arrays);
        algorithmSelectionSort.sort2(arrays);
        printArray(arrays);
    }

    private static void testBubbleSort() {
        int[] arrays = new int[] {2, 7, 11, 3, 5, 1, 4, 16, 13, 3, 12, 6, 9, 20};
        AlgorithmBubbleSort algorithmBubbleSort = new AlgorithmBubbleSort();
        algorithmBubbleSort.sort(arrays);
        printArray(arrays);
    }

    /**
     * print the all members, like "[,,,]"
     * @param array target array
     */
    public static void printArray(int[] array) {
        Utils.printArray(array);
    }
}
