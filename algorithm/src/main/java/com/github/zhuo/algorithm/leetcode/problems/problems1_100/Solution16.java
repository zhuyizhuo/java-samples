package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 提示：
 *   3 <= nums.length <= 10^3
 *   -10^3 <= nums[i] <= 10^3
 *   -10^4 <= target <= 10^4
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class Solution16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    /**
     * 题目可转换为
     *  找出 nums 中的三个整数,使得它们的和减去 target 最小。
     *
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 12.39% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 68.54% 的用户
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        //三数之和
        int threeSum = Integer.MAX_VALUE;
        //最小差值
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            //由于数组有序 如果一个正数与目标的差值就大于等于最小差值 可以直接返回三数之和
            if (nums[i] > 0 && nums[i] - target >= minResult) {
                return threeSum;
            }
            //如果第一个数和上个数重复 跳过
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < length - 1; j++) {
                //如果第二个数和上个数重复  跳过
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                for (int k = length - 1; k > j; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    //三数之和与目标值的差值
                    int abs = Math.abs(sum - target);
                    if (abs == 0){
                        //如果三数之和刚好等于目标值 直接返回
                        return sum;
                    }
                    //如果差值小于最小差值
                    if (abs < minResult){
                        minResult = abs;
                        threeSum = sum;
                    }
                }
            }
        }
        return threeSum;
    }
}

/**
 * beats 96.28%
 */
class ThreeSumClosest1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue; // 优化三
            }

            // 优化一
            int s = x + nums[i + 1] + nums[i + 2];
            if (s > target) { // 后面无论怎么选，选出的三个数的和不会比 s 还小
                if (s - target < minDiff) {
                    ans = s; // 由于下面直接 break，这里无需更新 minDiff
                }
                break;
            }

            // 优化二
            s = x + nums[n - 2] + nums[n - 1];
            if (s < target) { // x 加上后面任意两个数都不超过 s，所以下面的双指针就不需要跑了
                if (target - s < minDiff) {
                    minDiff = target - s;
                    ans = s;
                }
                continue;
            }

            // 双指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                s = x + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if (s - target < minDiff) { // s 与 target 更近
                        minDiff = s - target;
                        ans = s;
                    }
                    k--;
                } else { // s < target
                    if (target - s < minDiff) { // s 与 target 更近
                        minDiff = target - s;
                        ans = s;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
