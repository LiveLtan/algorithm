package com.ltan.algorithm.offer;

import java.util.Stack;

/**
 * Detail: from For-offer
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class MinStack {
    private Stack<Integer> nodes;
    private Stack<Integer> min;

    MinStack() {
        nodes = new Stack<>();
        min = new Stack<>();
    }

    public void push(int node) {
        nodes.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else if (node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        int op = nodes.pop();
        if (!min.isEmpty()) {
            if (op <= min.peek()) {
                min.pop();
            }
        }
    }

    public int top() {
        return nodes.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void run() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.min();
        minStack.push(4);
        minStack.min();
        minStack.push(2);
        minStack.min();
        minStack.push(3);
        minStack.min();

        minStack.pop();
        minStack.min();

        minStack.pop();
        minStack.min();

        minStack.pop();
        minStack.min();

        minStack.push(0);
        minStack.min();

        int min = minStack.min();
        System.out.println("min :" + min);
    }
}
