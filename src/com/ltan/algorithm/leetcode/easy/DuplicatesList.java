package com.ltan.algorithm.leetcode.easy;

import com.ltan.algorithm.utils.ListNode;
import com.ltan.algorithm.utils.Utils;

public class DuplicatesList {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            ListNode next = cur.next;
            while (next != null) {
                if (next.val == cur.val) {
                    cur.next = next.next;
                    next = next.next;
                } else {
                    cur = next;
                }
            }
            return head;
        }
    }

    public static void run() {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2, 3, 3};
        ListNode head = Utils.generateList(nums);
        Utils.printListNode(head);
        ListNode node = solution.deleteDuplicates(head);
        Utils.printListNode(node);
    }
}
