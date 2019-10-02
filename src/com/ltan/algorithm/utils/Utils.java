package com.ltan.algorithm.utils;

/**
 * Detail: public utils for algorithm
 *
 * Added by ltan on 2018/8/19
 */
public class Utils {

    public static boolean emptyArray(int[] nums) {
        return (nums == null || nums.length == 0);
    }

    /**
     * print the all members, like "[,,,]"
     * @param array target array
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
        }
        System.out.println("]");
    }

    /**
     *
     * @param array target nums array
     * @param length how many elements you want to print out.
     *
     * @see Utils#printArray(int[])
     */
    public static void printArray(int[] array, int length) {
        System.out.print("[");
        for(int i = 0; i < array.length && i < length; i++) {
            System.out.print((i == array.length - 1 || i== length - 1)
                    ? array[i] : array[i] + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(int[] array, int startIndex, int endIndex) {
        System.out.print("[");
        for(int i = startIndex; i < array.length && i < endIndex; i++) {
            System.out.print((i == array.length - 1 || i== endIndex - 1)
                    ? array[i] : array[i] + ", ");
        }
        System.out.println("]");
    }

    /**
     * If swipe, call this, java do not have swap API
     * @param nums target nums
     * @param index1 index1
     * @param index2 index2
     */
    public static void swap(int[] nums, int index1, int index2) {
        if(index1 < 0 || (index1 > nums.length - 1) || index2 < 0 || (index2 > nums.length - 1)) {
            return;
        }
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * Covert a string to an array
     *
     * @param elements must be start with '[' and end with ']'
     *                 such as [0,1,2] or [0,1,2,]
     */
    public static int[] generateArrayByString(String elements) {
        if(elements == null || elements.length() == 0) {
            return null;
        }
        elements = elements.replaceAll("\\s+", "");
        int firstIndex = elements.indexOf('[');
        int lastIndex = elements.indexOf(']');

        String[] array = elements.substring(firstIndex + 1, lastIndex).split(",");
        int[] retNums = new int[array.length];
        int i = 0;
        for(String s : array) {
            retNums[i++] = Integer.valueOf(s);
        }
        return retNums;
    }

    // tree node
    public static void printTreePre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ",");
        if (node.left != null) {
            printTreePre(node.left);
        }
        if (node.right != null) {
            printTreePre(node.right);
        }
    }

    public static void printTreeIn(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            printTreeIn(node.left);
        }
        System.out.print(node.val + ",");
        if (node.right != null) {
            printTreeIn(node.right);
        }
    }

    // link list
    public static ListNode generateList(int n) {
        ListNode head = new ListNode(1);
        ListNode p = head, q;
        for (int i = 1; i < n; i++) {
            q = new ListNode(i + 1);
            p.next = q;
            p = q;
        }
        return head;
    }
}
