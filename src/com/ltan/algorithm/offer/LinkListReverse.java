package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.ListNode;
import com.ltan.algorithm.utils.Utils;

import java.util.ArrayList;

/**
 * Detail: from For-offer reverse a linklist just print value
 * <p>
 * Created by tanlin on 2019-09-30
 */


public class LinkListReverse {

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
        ListNode head = Utils.generateList(10);
        ArrayList<Integer> list = llr.printListFromTailToHead(head);
        llr.printListNode(list);
    }

}
