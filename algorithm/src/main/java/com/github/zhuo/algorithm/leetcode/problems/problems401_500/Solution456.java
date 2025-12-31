package com.github.zhuo.algorithm.leetcode.problems.problems401_500;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/132-pattern/
 * 132模式
 * 难度 中等
 *
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
 * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 * Constraints:
 *   n == nums.length
 *   1 <= n <= 10^4
 *   -10^9 <= nums[i] <= 10^9
 */
public class Solution456 {

    public static void main(String[] args) {
//        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
        System.out.println(find132pattern(new int[]{1,2,3,2}));
    }

    /**
     * 10ms beats 97.89%
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }

}
