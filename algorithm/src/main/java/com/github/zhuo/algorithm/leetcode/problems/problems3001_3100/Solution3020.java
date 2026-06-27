package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

import java.util.HashMap;

/**
 * 子集中元素的最大数量
 */
public class Solution3020 {

    /**
     * beats 93.02%
     */
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge((long) x, 1, Integer::sum); // cnt[x]++
        }

        Integer c1 = cnt.remove(1L);
        int ans = c1 != null ? c1 - 1 | 1 : 0; // 保证 ans 是奇数（奇数不变，偶数减一）

        for (long x : cnt.keySet()) {
            int res = 0;
            while (cnt.getOrDefault(x, 0) >= 2) {
                res += 2;
                x *= x;
            }
            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }

        return ans;
    }
}