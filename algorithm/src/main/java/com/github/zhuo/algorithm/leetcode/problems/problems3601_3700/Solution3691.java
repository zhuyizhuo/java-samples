package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最大子数组总值 II
 * hard
 *
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 *
 * 你必须从 nums 中选择 恰好 k 个 不同 的非空子数组 nums[l..r]。子数组可以重叠，但同一个子数组（相同的 l 和 r）不能 被选择超过一次。
 *
 * 子数组 nums[l..r] 的 值 定义为：max(nums[l..r]) - min(nums[l..r])。
 *
 * 总值 是所有被选子数组的 值 之和。
 *
 * 返回你能实现的 最大 可能总值。
 *
 * 子数组 是数组中连续的 非空 元素序列。
 */
public class Solution3691 {

    private static class Node implements Comparable<Node> {

        int minRank, maxRank, diff;

        public Node(int minRank, int maxRank, int diff) {
            this.minRank = minRank;
            this.maxRank = maxRank;
            this.diff = diff;
        }

        @Override
        public int compareTo(Node o) {
            return o.diff - diff;
        }
    }

    /**
     * beats 100%
     */
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        int[] stack = new int[n];
        int top = 0;
        lefts[0] = -1;
        for(int i = 1, j = 0; i < n; i++) {
            int num = nums[i];
            for(; num < nums[j];) {
                rights[j] = i;
                if(--top < 0) {
                    j = -1;
                    break;
                }
                j = stack[top];
            }
            lefts[i] = j;
            stack[++top] = j = i;
        }
        do {
            rights[stack[top]] = n;
        } while (--top >= 0);

        long[] numIndices = new long[n];
        for(int i = 0; i < n; i++) {
            numIndices[i] = ((long)nums[i] << 32) | i;
        }
        Arrays.sort(numIndices);
        int[] indices = new int[n];
        for(int i = 0; i < n; i++) {
            indices[i] = (int)(numIndices[i] & Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, n - 1, nums[indices[n - 1]] - nums[indices[0]]));
        long sum = 0;
        for(Node node; (node = queue.poll()) != null; ) {
            int minRank = node.minRank;
            int maxRank = node.maxRank;
            int minIndex = indices[minRank];
            int maxIndex = indices[maxRank];
            int count;
            int left = lefts[minIndex];
            int right = rights[minIndex];
            if(maxIndex < minIndex) {
                if(maxIndex > left) {
                    count = (right - minIndex) * (maxIndex - left);
                    lefts[minIndex] = maxIndex;
                } else {
                    count = 0;
                }
            } else {
                if(maxIndex < right) {
                    count = (minIndex - left) * (right - maxIndex);
                    rights[minIndex] = maxIndex;
                } else {
                    count = 0;
                }
            }
            if(k <= count) {
                sum += (long)node.diff * k;
                return sum;
            } else {
                k -= count;
                sum += (long)node.diff * count;
            }
            if(minRank == 0 && maxRank > 1) {
                queue.add(new Node(minRank, maxRank - 1, nums[indices[maxRank - 1]] - nums[minIndex]));
            }
            if(minRank + 1 < maxRank) {
                queue.add(new Node(minRank + 1, maxRank, nums[maxIndex] - nums[indices[minRank + 1]]));
            }
        }
        return sum;
    }
}