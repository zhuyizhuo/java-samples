package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 将数组分成最小总代价的子数组 II
 * hard
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和两个 正 整数 k 和 dist 。
 *
 * 一个数组的 代价 是数组中的 第一个 元素。比方说，[1,2,3] 的代价为 1 ，[3,4,1] 的代价为 3 。
 *
 * 你需要将 nums 分割成 k 个 连续且互不相交 的子数组，满足 第二 个子数组与第 k 个子数组中第一个元素的下标距离 不超过 dist 。换句话说，如果你将 nums 分割成子数组 nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)] ，那么它需要满足 ik-1 - i1 <= dist 。
 *
 * 请你返回这些子数组的 最小 总代价。
 */
public class Solution3013 {

    /**
     * beats 100%
     */
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        PriorityQueue<Integer> left = new PriorityQueue<>(k, (a, b)->b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>(n - k + 1);
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        long sum = 0;

        k--;
        long minSum = Long.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(i >= dist + 2){
                int v = nums[i - dist - 1];
                if(v  < left.peek()){
                    map.merge(v, 1, Integer::sum);
                    size--;
                    sum -= v;
                }
                else if(v == left.peek()){
                    left.poll();
                    size--;
                    sum -= v;
                }
                else if(v == right.peek())
                    right.poll();
                else
                    map.merge(v, 1, Integer::sum);
            }

            if(i <= k || nums[i] <= left.peek()){
                left.offer(nums[i]);
                size++;
                sum += nums[i];
            }else{
                right.offer(nums[i]);
            }

            if(i > k ){
                if(size < k){
                    int v = right.poll();
                    left.offer(v);
                    size++;
                    sum += v;
                }
                else if(size > k){
                    int v = left.poll();
                    size--;
                    sum -= v;
                    right.offer(v);
                }
            }

            while(!left.isEmpty() && map.getOrDefault(left.peek(), 0) > 0)
                map.merge(left.poll(), -1, Integer::sum);

            while(!right.isEmpty() && map.getOrDefault(right.peek(), 0) > 0)
                map.merge(right.poll(), -1, Integer::sum);

            if(i >= dist + 1)
                minSum = Math.min(minSum, sum);

        }
        return minSum + nums[0];
    }
}