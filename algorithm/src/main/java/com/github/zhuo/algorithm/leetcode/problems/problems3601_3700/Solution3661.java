package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.*;

/**
 * 可以被机器人摧毁的最大墙壁数目
 * hard
 *
 * 一条无限长的直线上分布着一些机器人和墙壁。给你整数数组 robots ，distance 和 walls：
 * robots[i] 是第 i 个机器人的位置。
 * distance[i] 是第 i 个机器人的子弹可以行进的 最大 距离。
 * walls[j] 是第 j 堵墙的位置。
 * 每个机器人有 一颗 子弹，可以向左或向右发射，最远距离为 distance[i] 米。
 *
 * 子弹会摧毁其射程内路径上的每一堵墙。机器人是固定的障碍物：如果子弹在到达墙壁前击中另一个机器人，它会 立即 在该机器人处停止，无法继续前进。
 *
 * 返回机器人可以摧毁墙壁的 最大 数量。
 *
 * 注意：
 *
 * 墙壁和机器人可能在同一位置；该位置的墙壁可以被该位置的机器人摧毁。
 * 机器人不会被子弹摧毁。
 */
public class Solution3661 {
    static class Pair {
        int x, d;
        Pair(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    /**
     * beats 100%
     */
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int m = walls.length;

        // 长度 n+2，全部初始化，杜绝null和越界
        Pair[] a = new Pair[n + 2];
        // 第一步：把所有位置都初始化对象，绝对没有null
        for (int i = 0; i < n + 2; i++) {
            a[i] = new Pair(0, 0);
        }

        // 填充机器人数据
        for (int i = 0; i < n; i++) {
            a[i].x = robots[i];
            a[i].d = distance[i];
        }
        // 哨兵：最右侧无穷大
        a[n + 1].x = Integer.MAX_VALUE;

        // 排序：只排 0 ~ n 的位置，安全无null
        Arrays.sort(a, 0, n + 1, Comparator.comparingInt(p -> p.x));
        Arrays.sort(walls);

        int f0 = 0, f1 = 0;
        int left = 0, cur = 0;
        int right0 = 0, right1 = 0;

        // 核心循环：i 从 1 到 n，完全和C++一致
        for (int i = 1; i <= n; i++) {
            Pair curr = a[i];
            int x = curr.x;
            int d = curr.d;

            // 向左射击区间计算
            int leftX = Math.max(x - d, a[i - 1].x + 1);
            while (left < m && walls[left] < leftX) left++;
            while (cur < m && walls[cur] < x) cur++;

            int cur1 = cur;
            if (cur < m && walls[cur] == x) cur++;
            int leftRes = f0 + (cur - left);

            // 取下一个机器人（i+1 一定在数组范围内）
            Pair next = a[i + 1];
            int x2 = next.x;
            int d2 = next.d;

            // 右射情况1：右边机器人向左射
            int rightX = Math.min(x + d, x2 - d2 - 1);
            while (right0 < m && walls[right0] <= rightX) right0++;
            f0 = Math.max(leftRes, f1 + (right0 - cur1));

            // 右射情况2：右边机器人向右射
            rightX = Math.min(x + d, x2 - 1);
            while (right1 < m && walls[right1] <= rightX) right1++;
            f1 = Math.max(leftRes, f1 + (right1 - cur1));
        }

        return f1;
    }
}