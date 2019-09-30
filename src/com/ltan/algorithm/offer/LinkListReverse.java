package com.ltan.algorithm.offer;

import java.util.ArrayList;

/**
 * Detail: from For-offer reverse a linklist
 * <p>
 * Created by tanlin on 2019-09-30
 */


public class LinkListReverse {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode generateListNode() {
        ListNode head = new ListNode(10);
        ListNode p, q = head;
        for (int i = 0; i < 9; i++) {
            head.next = new ListNode(9 - i);
            p = head.next;
            head = p;
        }
        return q;
    }

    private void printListNode(ListNode head) {
        for (; head != null; head = head.next) {
            System.out.println("node:" + head.val);
        }
    }

    private void printListNode(ArrayList<Integer> values) {
        for (Integer i : values) {
            System.out.println("value:" + i);
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> rstList = new ArrayList<>();
        ListNode head = listNode;
        for (; head != null; head = head.next) {
            rstList.add(0, head.val);
        }
        return rstList;
    }

    public static void run() {
        LinkListReverse llr = new LinkListReverse();
        ListNode head = llr.generateListNode();
        ArrayList<Integer> list = llr.printListFromTailToHead(head);
        llr.printListNode(list);
    }

}
