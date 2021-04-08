package com.github.zhuo.algorithm.leetcode.problems.problems1800_1900.problems1817;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/finding-the-users-active-minutes/
 * 查找用户活跃分钟数
 * 难度 中等
 * 
 * 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [ID[i], time[i]] 表示 ID 为 ID[i] 的用户在 time[i] 分钟时执行了某个操作。
 *
 * 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
 *
 * 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。
 *
 * 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
 *
 * 返回上面描述的答案数组 answer 。
 *
 * 提示：
 *
 * 1 <= logs.length <= 10^4
 * 0 <= ID[i] <= 10^9
 * 1 <= time[i] <= 10^5
 * k 的取值范围是 [用户的最大用户活跃分钟数, 10^5]
 *
 */
public class FindingTheUsersActiveMinutes {

    public static void main(String[] args) {
        int[] ints = findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
//        int[] ints = findingUsersActiveMinutes(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    /**
     * 执行用时: 19 ms  超过 88%
     * 内存消耗: 48.6 MB
     */
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] resp = new int[k];
        Map<Integer,Map<Integer, Integer>> map = new HashMap<>(1000);
        for (int i = 0; i < logs.length; i++) {
            Map<Integer, Integer> innerMap = map.get(logs[i][0]);
            if (innerMap == null){
                innerMap = new HashMap<>();
                innerMap.put(logs[i][1], 1);
                map.put(logs[i][0], innerMap);
            } else {
                Integer integer = innerMap.get(logs[i][1]);
                if (integer == null){
                    innerMap.put(logs[i][1], 1);
                }
            }
        }
        if (!map.isEmpty()){
            for (Map.Entry<Integer, Map<Integer, Integer>> integerMapEntry : map.entrySet()) {
                resp[integerMapEntry.getValue().size() - 1]++;
            }
        }
        return resp;
    }
}
