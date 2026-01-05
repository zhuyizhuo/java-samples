package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * 跳跃游戏 II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 *
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 */
public class Solution45 {

    /**
     * beats 100%
     */
    private int choose(int[] nums, int start, int step) {
        // 终止条件
        if (start >= nums.length - 1) return step;
        if (start + nums[start] >= nums.length - 1) return step + 1;

        // 寻找最佳下一个位置
        int maxReach = 0;
        int bestNext = start;

        for (int i = start + 1; i <= start + nums[start]; i++) {

            // 计算从i能到达的位置
            int reach = i + nums[i];
            if (reach > maxReach) {
                maxReach = reach;
                bestNext = i;
            }
        }

        // 递归
        return choose(nums, bestNext, step + 1);
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        return choose(nums, 0, 0);
    }
}
