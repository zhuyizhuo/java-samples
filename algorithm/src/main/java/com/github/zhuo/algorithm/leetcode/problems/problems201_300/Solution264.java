package com.github.zhuo.algorithm.leetcode.problems.problems201_300;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * 丑数 II
 * 难度 中等
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class Solution264 {

    public static void main(String[] args) {
    }

    /**
     * 执行用时： 64 ms , 在所有 Java 提交中击败了 19.68% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 7.66% 的用户
     */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    /**
     * 2ms beats 100%
     */
    public int nthUglyNumber1(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int x = res[a] * 2;
            int y = res[b] * 3;
            int z = res[c] * 5;
            res[i] = Math.min(x, Math.min(y, z));
            if (res[i] == x) {
                a++;
            }
            if (res[i] == y) {
                b++;
            }
            if (res[i] == z) {
                c++;
            }
        }
        return res[n - 1];
    }
}
