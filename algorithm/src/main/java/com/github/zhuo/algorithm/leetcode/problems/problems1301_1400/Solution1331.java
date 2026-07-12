package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换
 * easy
 */
public class Solution1331 {

    /**
     * beats 93.14%
     */
    public int[] arrayRankTransform(int[] arr) {
        // 边界处理：空数组直接返回
        if (arr == null || arr.length == 0) return new int[0];

        // 1. 克隆并排序（保留原数组顺序）
        int[] sorted = arr.clone();
        Arrays.sort(sorted); // O(n log n)

        // 2. 去重 + 构建排名映射（关键：跳过重复值）
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1; // 序号从1开始
        for (int i = 0; i < sorted.length; i++) {
            // 仅当当前值与前一个不同（或首元素）时分配新排名
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                rankMap.put(sorted[i], rank++);
            }
        }

        // 3. 替换原数组元素为排名
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]); // O(1) 查询
        }
        return result;
    }
}