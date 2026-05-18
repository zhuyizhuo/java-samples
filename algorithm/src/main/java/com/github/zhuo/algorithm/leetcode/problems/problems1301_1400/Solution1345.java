package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

import java.util.*;

/**
 * 跳跃游戏 IV
 * hard
 */
public class Solution1345 {

    /**
     * beats 98.41%
     */
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // 记录每个值对应的所有下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();

                // 到达终点
                if (idx == n - 1) return step;

                // 1. 跳到 idx+1
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }
                // 2. 跳到 idx-1
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }
                // 3. 跳到所有相同值的位置
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    // 关键优化：用过就删，避免重复遍历
                    map.remove(arr[idx]);
                }
            }
            step++;
        }
        return step;
    }
}