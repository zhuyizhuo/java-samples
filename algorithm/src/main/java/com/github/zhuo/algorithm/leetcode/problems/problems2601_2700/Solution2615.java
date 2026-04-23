package com.github.zhuo.algorithm.leetcode.problems.problems2601_2700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 等值距离和
 *
 * 给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
 *
 * 返回数组 arr 。
 */
public class Solution2615 {

    /**
     * beats 95.07%
     */
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        // 1. 分组：key 是数值，value 是该数值出现的所有下标列表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // 2. 遍历每一组相同数值的下标
        for (List<Integer> idxList : map.values()) {
            int size = idxList.size();
            if (size == 1) {
                // 只有一个元素，距离和为 0，无需处理
                continue;
            }

            // 计算这组下标的前缀和数组
            long[] preSum = new long[size + 1];
            for (int i = 0; i < size; i++) {
                preSum[i + 1] = preSum[i] + idxList.get(i);
            }

            // 3. 利用公式计算每一个位置的结果
            for (int i = 0; i < size; i++) {
                long pos = idxList.get(i);
                // 左边计算
                long left = pos * i - preSum[i];
                // 右边计算
                long right = (preSum[size] - preSum[i + 1]) - pos * (size - i - 1);
                // 赋值
                arr[(int) pos] = left + right;
            }
        }

        return arr;

    }
}