package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

import java.util.Arrays;

/**
 * 正方形上的点之间的最大距离
 * hard
 */
public class Solution3464 {

    /**
     * beats 91.3 %
     */
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] a = new long[n];

        // 1. 把正方形四边上的点展开成一维线性数组
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) {
                a[i] = y;
            } else if (y == side) {
                a[i] = (long) side + x;
            } else if (x == side) {
                a[i] = 3L * side - y;
            } else { // y == 0
                a[i] = 4L * side - x;
            }
        }

        // 2. 排序
        Arrays.sort(a);

        int[] f = new int[n + 1];  // DP 数组：从 i 开始最多选几个
        int[] end = new int[n];    // 记录每组最后一个点的位置

        // 3. 二分答案：check 函数判断间距至少为 low 时，能否选出 k 组
        int left = 1;
        int right = (int) (4L * side / k) + 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, a, side, k, f, end)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // 核心 check：间距 >= low 时，能否选出 k 个满足环形条件的点
    private boolean check(int low, long[] a, int side, int k, int[] f, int[] end) {
        int n = a.length;
        Arrays.fill(f, 0); // 重置 DP 数组
        int j = n;

        for (int i = n - 1; i >= 0; i--) {
            // 找到第一个 >= a[i] + low 的位置
            while (j - 1 >= 0 && a[j - 1] >= a[i] + low) {
                j--;
            }
            f[i] = f[j] + 1;
            end[i] = (f[i] > 1) ? end[j] : i;

            // 满足 k 个 + 环形首尾不冲突
            if (f[i] == k && a[end[i]] - a[i] <= 4L * side - low) {
                return true;
            }
        }
        return false;
    }
}