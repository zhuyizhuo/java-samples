package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

import java.util.Arrays;

/**
 * 分割正方形 II
 *
 * hard
 *
 * 给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
 *
 * 找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
 *
 * 答案如果与实际答案的误差在 10-5 以内，将视为正确答案。
 *
 * 注意：正方形 可能会 重叠。重叠区域只 统计一次 。
 */
public class Solution3454 {
    int[] len, coverLen, coverCnt;

    /**
     * beats 100%
     * @param squares
     * @return
     */
    public double separateSquares(int[][] squares) {
        int n = squares.length << 1, p = 1;
        int[] xs = new int[n + 1];
        for (int[] s : squares) {
            xs[p++] = s[0];
            xs[p++] = s[0] + s[2];
        }
        Arrays.sort(xs);
        int m = 1;
        for (int i = 2; i <= n; ++i) {
            if (xs[m] != xs[i]) {
                xs[++m] = xs[i];
            }
        }
        xs[0] = xs[1];
        int[][] qs = new int[n][];
        p = 0;
        for (int[] s : squares) {
            int x1 = lower_bound(xs, 1, m, s[0]), x2 = lower_bound(xs, 1, m, s[0] + s[2]);
            qs[p++] = new int[] { s[1], x1, x2, 1 };
            qs[p++] = new int[] { s[1] + s[2], x1, x2, -1 };
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int sz = 2 << (32 - Integer.numberOfLeadingZeros(m - 1));
        len = new int[sz];
        coverLen = new int[sz];
        coverCnt = new int[sz];
        build(1, 1, m, xs);
        long totArea = 0;
        long[][] memo = new long[n][];
        p = 0;
        int i = 0, preY = 0;
        while (i < n) {
            int curY = qs[i][0];
            long area = (long) (curY - preY) * coverLen[1];
            totArea += area;
            memo[p++] = new long[]{curY, area, coverLen[1]};
            for (; i < n && qs[i][0] == curY; ++i) {
                update(1, 1, m, qs[i][1] + 1, qs[i][2], qs[i][3]);
            }
            preY = curY;
        }
        long area = 0;
        for(long[] a : memo){
            area += a[1];
            if(area * 2 >= totArea){
                return a[0] - (area * 2 - totArea) / (a[2] * 2.0);
            }
        }
        return -1;
    }

    public void update(int o, int l, int r, int L, int R, int c) {
        if (L <= l && r <= R) {
            coverCnt[o] += c;
            if (coverCnt[o] > 0) {
                coverLen[o] = len[o];
            } else if (l == r) {
                coverLen[o] = 0;
            } else {
                coverLen[o] = coverLen[o << 1] + coverLen[o << 1 | 1];
            }
            return;
        }
        int mid = (l + r) >> 1;
        if (L <= mid) {
            update(o << 1, l, mid, L, R, c);
        }
        if (R > mid) {
            update(o << 1 | 1, mid + 1, r, L, R, c);
        }
        if (coverCnt[o] == 0) {
            coverLen[o] = coverLen[o << 1] + coverLen[o << 1 | 1];
        }
    }

    public void build(int o, int l, int r, int[] xs) {
        len[o] = xs[r] - xs[l - 1];
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(o << 1, l, mid, xs);
        build(o << 1 | 1, mid + 1, r, xs);
    }

    public int lower_bound(int[] xs, int left, int right, int k) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (xs[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}