package com.github.zhuo.algorithm.leetcode.problems.problems401_500;

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
        //TODO 待补充
//        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
        System.out.println(find132pattern(new int[]{1,2,3,2}));
    }

    /**
     * 子序列 不一定是连续的
     */
    public static boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3){
            return false;
        }
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                if (nums[i] < nums[j]){
                    for (int k = j + 1; k < length; k++) {
                        if (k > j + 1 && nums[k] == nums[k-1]){
                            continue;
                        }
                        if (nums[i] < nums[k] && nums[k] < nums[j]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
