package com.ltan.algorithm.leetcode.easy;

/**
 * Details: From leetcode 21
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made
 * by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * created by ltan on 2019-01-12
 */
public class MergeSortedList {
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
        /**
         * todo use a loop
         * @see #mergeTwoLists2(ListNode, ListNode)
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

        /**
         * remove the extra value as a set.
         *
         * @param l1 list 1
         * @param l2 list 2
         * @return merged list
         */
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val == l2.val) {
                // clear the same value
                l1.next = mergeTwoLists(l1.next, l2.next);
                return l1;
                /*l2.next = mergeTwoLists(l1.next, l2.next);
                return l2;*/
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    public static void run() {
        Solution s = new Solution();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        generateTwoList(l1, 1, 2, 5, 6, 8);
        generateTwoList(l2, 1, 3, 5, 8, 9);

        ListNode l3 = s.mergeTwoLists(l1, l2);
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