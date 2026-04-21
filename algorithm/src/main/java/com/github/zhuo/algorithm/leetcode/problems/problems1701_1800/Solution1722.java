package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行交换操作后的最小汉明距离
 */
public class Solution1722 {

    private int[] fa;
    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }
    private void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) fa[y] = x;
        else fa[x] = y;
    }

    /**
     * beats 98.92%
     */
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int[] x : allowedSwaps) {
            join(x[0], x[1]);
        }
        Map<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            int j = find(i);
            map[j].put(source[i], map[j].getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = find(i);
            if (map[j].getOrDefault(target[i], 0) > 0) {
                map[j].put(target[i], map[j].get(target[i]) - 1);
                res++;
            }
        }
        return n - res;
    }
}