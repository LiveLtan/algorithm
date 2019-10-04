package com.ltan.algorithm.offer;

import java.util.LinkedList;

/**
 * Detail: from For-offer random link list
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class RandomLinkList {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * O(n) + S(n)
     * @param pHead
     * @return
     */
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        LinkedList<RandomListNode> listNodes = new LinkedList<>();
        LinkedList<RandomListNode> listNewNodes = new LinkedList<>();
        RandomListNode p = pHead;
        RandomListNode nHead = null;
        RandomListNode q, r = null;
        while (p != null) {
            q = new RandomListNode(p.label);
            if (nHead == null) {
                r = nHead = q;
            } else {
                r.next = q;
                r = q;
            }
            listNewNodes.add(q);
            listNodes.add(p);
            p = p.next;
        }

        for (int i = 0; i < listNodes.size(); i++) {
            RandomListNode node = listNodes.get(i);
            int index = listNodes.indexOf(node.random);
            if (index == -1) {
                listNewNodes.get(i).random = null;
            } else {
                listNewNodes.get(i).random = listNewNodes.get(index);
            }
        }

        return listNewNodes.get(0);
    }

    /**
     * chancy: https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba?f=discussion
     * O(n) + S(1)
     * @param pHead
     * @return
     */
    public RandomListNode clonePerf(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        // 1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        // 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        // 3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    private static RandomListNode generateRandomList(int start) {
        RandomListNode root = new RandomListNode(start);
        RandomListNode p = root;
        for (int i = 1; i < 5; i++) {
            p.next = new RandomListNode((i + start));
            p = p.next;
        }
        root.random = root.next.next;
        root.next.random = null;
        root.next.next.random = root.next;
        root.next.next.next.random = root.next.next.next.next;
        root.next.next.next.next.random = root.next;
        return root;
    }

    public static void run() {
        RandomLinkList linkList = new RandomLinkList();
        RandomListNode root = generateRandomList(1);
        RandomListNode cloned = linkList.clone(root);
        System.out.println("cloned" + cloned);
    }
}
