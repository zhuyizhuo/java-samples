package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.Arrays;

/**
 * 三个相等元素之间的最小距离 II
 *
 * 给你一个整数数组 nums。
 *
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 *
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 *
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
 */
public class Solution3741 {

    /**
     * beats 98.88%
     */
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        int[] pos = new int[n + 1];
        Arrays.fill(pos, -1);
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            if (pos[x] == -1) {
                suf[i] = -1;
            } else {
                suf[i] = pos[x];
            }
            pos[x] = i;
        }
        Arrays.fill(pos, -1);
        pos[nums[0]] = 0;
        int ans = n;
        for (int i = 1; i < n - 1; i++) {
            int x = nums[i];
            if (pos[x] != -1 && suf[i] != -1) {
                ans = Math.min(ans, suf[i] - pos[x]);
            }
            pos[x] = i;
        }
        return ans == n ? -1 : (2 * ans);
    }
}
