package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.ListNode;
import com.ltan.algorithm.utils.Utils;


/**
 * Detail: from For-offer reverse a linklist
 * <p>
 * Created by tanlin on 2019-10-02
 */
public class ReverseLink {

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        if (p != null) {
            q = p.next;
            p.next = null;
        }
        while (q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        return p;
    }

    public static void run() {
        ReverseLink reverseLink = new ReverseLink();
        ListNode head = Utils.generateList(10);
        Utils.printListNode(head);
        head = reverseLink.reverseList(head);
        Utils.printListNode(head);
    }
}
