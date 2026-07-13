package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 顺次数
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 */
public class Solution1291 {

    /**
     * beats 100%
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int d = 1; d <= 9; d++) {
            int x = d;
            for (int i = d; i <= 9 && x <= high; i++) {
                if (x >= low) {
                    ans.add(x);
                }
                x = x * 10 + i + 1;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}