package com.github.zhuo.algorithm.leetcode.problems.problems101_200.problems167;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和 II - 输入有序数组
 * 难度 中等
 *
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    /**
     * 两数之和
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 20.28% 的用户
     * 内存消耗： 43.5 MB , 在所有 Java 提交中击败了 95.69% 的用户
     * 通过测试用例： 21 / 21
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]), i+1};
            }
            map.put(numbers[i], i+1);
        }
        return new int[]{-1, -1};
    }

}
