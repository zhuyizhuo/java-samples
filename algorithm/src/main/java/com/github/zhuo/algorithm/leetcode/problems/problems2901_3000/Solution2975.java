package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。
 *
 * 水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。
 *
 * 返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。
 *
 * 由于答案可能很大，所以请返回结果对 109 + 7 取余 后的值。
 *
 * 注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。
 */
public class Solution2975 {

    /**
     * beats 84.52%
     */
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = (int)1e9 + 7;
        if (m == n) return (int)((long) (m - 1) * (n - 1) % MOD);
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> set = new HashSet<>();
        set.add(m - 1);
        for (int i = 0; i < hFences.length; i++) {
            set.add(hFences[i] - 1);
            set.add(m - hFences[i]);
            for (int j = i + 1; j < hFences.length; j++) {
                set.add(hFences[j] - hFences[i]);
            }
        }
        int res = 0;
        if (set.contains(n - 1)) res = n - 1;
        for (int i = 0; i < vFences.length; i++) {
            if (set.contains(vFences[i] - 1)) res = Math.max(res, vFences[i] - 1);
            if (set.contains(n - vFences[i])) res = Math.max(res, n - vFences[i]);
            for (int j = i + 1; j < vFences.length; j++) {
                if (set.contains(vFences[j] - vFences[i])) {
                    res = Math.max(res, vFences[j] - vFences[i]);
                }
            }
        }
        return res == 0? -1 : (int)((long) res * res % MOD);
    }
}