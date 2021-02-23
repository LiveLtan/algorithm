package com.ltan.algorithm.utils;

import java.util.LinkedList;

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
    public static TreeNode generateTreeNode(int[] nums) {
        return generateTreeNode(nums, 0);
    }
    public static TreeNode generateTreeNode(int[] nums, int offset) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i] + offset);
            nodes.add(node);
        }
        TreeNode root = nodes.get(0);
        if (nodes.size() == 1) {
            return root;
        }
        for (int l = 0; l < nums.length / 2 - 1; l++) {
            nodes.get(l).left = nodes.get(l * 2 + 1);
            nodes.get(l).right = nodes.get(l * 2 + 2);
        }
        int lastPIndex = nums.length / 2 - 1;
        nodes.get(lastPIndex).left = nodes.get(lastPIndex * 2 + 1);
        // if not even
        if ((nums.length & 0x1) == 1) {
            nodes.get(lastPIndex).right = nodes.get(lastPIndex * 2 + 2);
        }
        return root;
    }

    public static void checkTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == -1) {
            root.left = null;
            root.right = null;
        }
        if (root.left != null && root.left.val == -1) {
            root.left = null;
        } else {

            checkTree(root.left);
        }
        if (root.right != null && root.right.val == -1) {
            root.right = null;
        } else {

            checkTree(root.right);
        }
    }

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
    public static ListNode generateList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head, q;
        for (int i = 1; i < nums.length; i++) {
            q = new ListNode(nums[i]);
            p.next = q;
            p = q;
        }
        return head;
    }

    public static ListNode generateList(int n, int start) {
        ListNode head = new ListNode(start);
        ListNode p = head, q;
        for (int i = 1; i < n; i++) {
            q = new ListNode(i + start);
            p.next = q;
            p = q;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        System.out.print("nodes:");
        for (; head != null; head = head.next) {
            System.out.print(head.val + ",");
        }
        System.out.println();
    }

    // for int[][]
    public static int[][] generateMatrix(int[] nums, int row, int column) {
        if (nums == null || nums.length < (row * column)) {
            throw new IllegalArgumentException("nums length must twice of vector " + (row * column) + " but " + nums.length);
        }
        int[][] matrix = new int[row][column];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = nums[k++];
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
