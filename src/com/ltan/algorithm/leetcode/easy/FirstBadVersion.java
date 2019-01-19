package com.ltan.algorithm.leetcode.easy;

/**
 * Details: from leetcode 278
 * see leetcode 35 (Easy)
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version
 * is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 * <p>
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 * <p>
 * created by ltan on 2019-01-19
 */
public class FirstBadVersion {
    static class VersionControl {
        int v = 1;
        boolean isBadVersion(int version) {
            return version >= v;
        }
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n, int v) {
            this.v = v;
            int l = 1, r = n, mid = 1;
            while (l < r) {
                mid = l + (r - l) / 2;
                if(isBadVersion(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public int firstBadVersion2(int n, int v) {
            for (int i = 1; i < n; i++) {
                if(isBadVersion(i)) {
                    return i;
                }
            }
            return n;
        }
    }

    public static void run() {
        Solution s = new Solution();
        //int f = s.firstBadVersion(5, 4);
        int f = s.firstBadVersion(5, 4);
        System.out.println("first bad version:" + f);
    }
}