package com.ltan.algorithm.leetcode.easy;

/**
 * Detail: From Leetcode 2
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * Added by ltan on 2018/8/19
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            //ListNode result = new ListNode(0);
            ListNode l3 = result;
            int carry = 0;
            while (l1 != null && l2 != null) {
                l3.val = l1.val + l2.val + carry;
                carry = calculateCarry(l3);

                l1 = l1.next;
                l2 = l2.next;
                if ((l1 != null || l2 != null) || carry > 0) {
                    l3.next = new ListNode(carry);
                }
                l3 = l3.next;
            }
            handleExtra(l3, l1);
            handleExtra(l3, l2);
            return result;
        }

        /**
         * handle the bigger listnode
         *
         * @param l3   source list
         * @param list the left list which length is great than other listnode
         */
        private void handleExtra(ListNode l3, ListNode list) {
            if (l3 == null || list == null) {
                return;
            }
            int carry = 0;
            if (list.val > 0 || list.next != null) {
                l3.val += list.val;
                l3.next = list.next;
                while (l3 != null) {
                    carry = calculateCarry(l3);
                    if (carry <= 0) {
                        break; // means no carry, just append list into source list l3.
                    } else if (l3.next != null) {
                        l3.next.val += carry;
                    } else {
                        l3.next = new ListNode(carry);
                    }
                    l3 = l3.next;
                }
            }
        }

        /**
         * calculate the current node carray
         *
         * @param node list node
         * @return carry
         */
        private int calculateCarry(ListNode node) {
            if (node == null) {
                return 0;
            }
            int carry = 0;
            if (node.val >= 10) {
                carry = node.val / 10;
                node.val = node.val % 10;
            }
            return carry;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        generateTwoList(l1, 8, 3, 6, 9, 0, 9, 9, 9, 1, 2, 9, 0);
        generateTwoList(l2, 6, 7, 9, 2, 1, 5, 2);

        /*generateTwoList(l1, 1);
        generateTwoList(l2, 9,8,0,9);*/

        /*generateTwoList(l1, 0);
        generateTwoList(l2, 0, 9);*/
        System.out.println("Input:");
        printNodeList(l1);
        printNodeList(l2);

        ListNode l3 = solution.addTwoNumbers(l1, l2);
        System.out.println("Output:");
        printNodeList(l3);
    }

    private static void generateTwoList(ListNode l, int... vals) {
        if (l == null || vals == null || vals.length == 0) {
            return;
        }
        int count = vals.length;
        if (vals[vals.length - 1] <= 0) {
            count--;
        }
        l.val = vals[0];
        for (int i = 1; i < count; i++) {
            l.next = new ListNode(vals[i]);
            l = l.next;
        }
    }

    private static void printNodeList(ListNode l) {
        while (l != null) {
            if (l.next != null) {
                System.out.print(l.val + " -> ");
            } else {
                System.out.print(l.val);
            }
            l = l.next;
        }
        System.out.println();
    }
}


