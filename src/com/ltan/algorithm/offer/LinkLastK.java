package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.ListNode;
import com.ltan.algorithm.utils.Utils;

/**
 * Detail: from For-offer find last K index node
 * <p>
 * Created by tanlin on 2019-10-02
 */
public class LinkLastK {

    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        int i = 0;
        ListNode p = head;
        ListNode rst = head;
        while (p != null && i < k) {
            p = p.next;
            i++;
        }

        if (p == null && i < k) {
            return null;
        }

        while (rst != null && p != null) {
            rst = rst.next;
            p = p.next;
        }
        return rst;
    }

    public static void run() {
        LinkLastK linkLastK = new LinkLastK();
        ListNode head = Utils.generateList(5);

        ListNode k = linkLastK.findKthToTail(head, 5);
        System.out.println("the last k is:" + k.val);
    }
}
