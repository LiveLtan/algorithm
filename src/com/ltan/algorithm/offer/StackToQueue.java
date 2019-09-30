package com.ltan.algorithm.offer;

import java.util.Stack;

/**
 * Detail: from from For-offer implement queue by two stacks
 * <p>
 * Created by tanlin on 2019-09-30
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            int r = stack1.pop();
            stack2.push(r);
        }
        return stack2.pop();
    }

    public static void run() {
        StackToQueue stq = new StackToQueue();
        stq.push(1);
        stq.push(2);
        stq.push(3);
        stq.pop();
        stq.pop();
        stq.push(4);
        stq.pop();
        stq.push(5);
        stq.pop();
        stq.pop();
        int rst = stq.pop();
        System.out.println("rst:" + rst);
    }
}
