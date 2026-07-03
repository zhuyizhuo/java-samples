package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;
import java.util.*;

/**
 * 恢复网络路径
 * hard
 */
public class Solution3620 {

    private int[][] edgesBySrc;

    private int[] offsets;

    private int[] queue;

    private int tail;

    private long[] minSums;

    private int n;

    /**
     * beats 87.13%
     */
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        int[] prevCounts = new int[n];
        offsets = new int[n + 1];
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for(int[] edge : edges) {
            prevCounts[edge[1]]++;
            offsets[edge[0]]++;
            int cost = edge[2];
            maxCost = Math.max(maxCost, cost);
            minCost = Math.min(minCost, cost);
        }
        int offset = offsets[0];
        for(int i = 1; i < n; i++) {
            offsets[i] = offset += offsets[i];
        }
        offsets[n] = offset;

        edgesBySrc = new int[edges.length][];
        for(int[] edge : edges) {
            edgesBySrc[--offsets[edge[0]]] = edge;
        }

        tail = 0;
        queue = new int[n];
        for(int i = 0; i < n; i++) {
            if (prevCounts[i] == 0) {
                queue[tail++] = i;
            }
        }

        minSums = new long[n];
        Arrays.fill(minSums, 1, n, Long.MAX_VALUE);

        int head = 0;
        for(; head < tail;) {
            int i = queue[head++];
            if(i == n - 1) {
                tail = head;
                break;
            }
            long minSum = minSums[i];
            for(int j = offsets[i], end = offsets[i + 1]; j < end; j++) {
                int[] edge = edgesBySrc[j];
                int dst = edge[1];
                if(minSum <= k && online[dst]) {
                    minSums[dst] = Math.min(minSums[dst], minSum + edge[2]);
                }
                if(--prevCounts[dst] > 0) {
                    continue;
                }
                queue[tail++] = dst;
            }
        }

        if(minSums[n - 1] > k) {
            return -1;
        }

        for(head = 0; head < tail && minSums[queue[head]] <= k; head++);
        int newTail = head;
        for(; head < tail; head++) {
            int nodeId = queue[head];
            if(minSums[nodeId] <= k) {
                queue[newTail++] = nodeId;
            }
        }
        tail = newTail;

        for(; minCost < maxCost;) {
            int midCost = minCost + maxCost + 1 >>> 1;
            if(findPath(midCost, k)) {
                minCost = midCost;
            } else {
                maxCost = midCost - 1;
            }
        }
        return minCost;
    }

    private boolean findPath(int minCost, long k) {
        Arrays.fill(minSums, 1, n, Long.MAX_VALUE);
        for(int head = 0; head < tail; head++) {
            int nodeId = queue[head];
            long minSum = minSums[nodeId];
            if(minSum > k) {
                continue;
            }
            for(int i = offsets[nodeId], end = offsets[nodeId + 1]; i < end; i++) {
                int[] edge = edgesBySrc[i];
                int dst = edge[1];
                int cost = edge[2];
                if(cost < minCost) {
                    continue;
                }
                long minSumDst = minSum + cost;
                if(dst == n - 1 && minSumDst <= k) {
                    return true;
                }
                minSums[dst] = Math.min(minSums[dst], minSumDst);
            }
        }
        return false;
    }
}