package com.ltan.algorithm.leetcode.easy;


import com.ltan.algorithm.utils.TreeNode;

import java.util.ArrayDeque;

/**
 * Detail: from Leetcode 100
 * <p>
 * Created by tanlin on 2020-10-12
 */
public class SameTree {

    static class Solution {

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null) {
                return q == null;
            }
            if (q == null) {
                return false;
            }

            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        public boolean check(TreeNode p, TreeNode q) {
            // p and q are null
            if (p == null && q == null) return true;
            // one of p and q is null
            if (q == null || p == null) return false;
            return (p.val == q.val);
        }

        public boolean isSameTree2(TreeNode p, TreeNode q) {
            if (p == null) {
                return q == null;
            }
            if (q == null) {
                return false;
            }

            // init deques
            ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
            ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
            deqP.addLast(p);
            deqQ.addLast(q);

            while (!deqP.isEmpty()) {
                p = deqP.removeFirst();
                q = deqQ.removeFirst();

                if (!check(p, q)) return false;
                if (p != null) {
                    // in Java nulls are not allowed in Deque
                    if (!check(p.left, q.left)) return false;
                    if (p.left != null) {
                        deqP.addLast(p.left);
                        deqQ.addLast(q.left);
                    }
                    if (!check(p.right, q.right)) return false;
                    if (p.right != null) {
                        deqP.addLast(p.right);
                        deqQ.addLast(q.right);
                    }
                }
            }
            return true;
        }

    }
}
