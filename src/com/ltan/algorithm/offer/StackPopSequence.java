package com.ltan.algorithm.offer;

import com.ltan.algorithm.utils.Utils;

import java.util.Stack;

/**
 * Detail: from Leetcode
 * <p>
 * Created by tanlin on 2019-10-04
 */
public class StackPopSequence {
    /**
     * lizo: https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106?answerType=1&f=discussion
     *
     * @param pushA push sequence
     * @param popA pop sequence
     * @return true if right sequence
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int value : pushA) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void run() {
        StackPopSequence popSequence = new StackPopSequence();
        int[] pushs = Utils.generateArrayByString("[1,2,3,4,5]");
        int[] pops = Utils.generateArrayByString("[5,4,3,2,0]");
        boolean rst = popSequence.isPopOrder(pushs, pops);
        System.out.println("is pop sequence ?" + rst);
    }
}
