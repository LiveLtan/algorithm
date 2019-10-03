package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.ListNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from NowCoder merge two lists sorted
 * <p>
 * Created by tanlin on 2019-10-03
 */
public class ListMerge {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode rst = list1.val <= list2.val ? list1 : list2;
        ListNode p1, p2, p1p = null, p2p;
        p1 = list1;
        p2p = p2 = list2;
        while (p1 != null && p2 != null) {
            if (p2.val < p1.val) {
                ListNode p2n = p2.next;
                if (p1p == null) {
                    p2.next = p1;
                } else {
                    p2.next = p1;
                    p1p.next = p2;
                }
                p1p = p2;
                p2p = p2;
                p2 = p2n;
            } else {
                p1p = p1;
                p1 = p1.next;
            }
        }
        if (p2 != null) {
            p1p.next = p2;
        }
        if (p1 != null) {
            p2p.next = p1;
        }
        return rst;
    }

    /**
     * ref: https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337?f=discussion
     * */
    public ListNode merge2(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }

    public static void run() {
        ListMerge listMerge = new ListMerge();
        ListNode list1 = Utils.generateList(3, 6);
        ListNode list2 = Utils.generateList(3);
        ListNode rstNode = listMerge.merge(list1, list2);
        Utils.printListNode(rstNode);
    }
}
