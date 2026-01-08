package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * 形成两个异或相等数组的三元组数目
 * 难度 中等
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 */
public class Solution1442 {

    /**
     * 1ms beats 100%
     */
    public int countTriplets(int[] arr) {
        int n = arr.length;
        // 异或前缀和，（次数，下标和）
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 0});
        int s = 0;
        int ans = 0;

        for(int k = 0; k < n; k++){
            s ^= arr[k];
            if(map.containsKey(s)){
                int[] info = map.get(s);
                int count = info[0];
                int totalIndex = info[1];

                ans += count*k - totalIndex;

                info[0]++;
                info[1] += (k + 1);
            }else{
                map.put(s, new int[]{1, k + 1});
            }
        }
        return ans;
    }
}
