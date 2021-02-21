package com.github.zhuo.algorithm.leetcode.problems697;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * 数组的度
 * 难度 简单
 * 
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        //todo 可继续优化
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }

    /**
     * 思路
     *  题目可转换为  在非负整数数组中找到出现频数最多的元素的起始和结束下标
     *
     *  所以我们需要统计每个元素的出现次数 首次出现下标 和当前下标
     *  最终取出出现最多的元素的结束下标减去出现下标+1 即为最短连续子数组的长度
     *
     *  因为可能会有出现次数相同的元素 所以需取长度最小的元素
     *
     * 执行用时： 26 ms , 在所有 Java 提交中击败了 70.75% 的用户
     * 内存消耗： 43.2 MB , 在所有 Java 提交中击败了 23.96% 的用户
     */
    public static int findShortestSubArray(int[] nums) {
        //统计总数
        Map<Integer, Integer> countMap = new HashMap<>();
        //记录开始下标
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        //记录结束下标
        Map<Integer, Integer> currIndexMap = new HashMap<>();
        int len = nums.length;
        /** 最多出现的元素次数 */
        int max = 1;
        /** 最多出现的元素 默认为第一个 */
        int item = nums[0];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            Integer integer = countMap.get(num);
            //如果元素没出现过
            if (integer == null) {
                //记录元素出现次数为1
                countMap.put(num, 1);
                //记录元素出现的开始下标
                startIndexMap.put(num, i);
            } else {
                //如果元素出现过 则将出现次数+1
                countMap.put(num, integer + 1);
                if (integer + 1 > max){
                    item = num;
                    max = integer + 1;
                } else if (integer + 1 == max){
                    //如果出现次数相同 比较长度谁更小 因为两数相比 所以此处都未加1
                    int itemLength = currIndexMap.get(item) - startIndexMap.get(item);
                    //当前元素的下标减去当前元素的开始下标 即当前元素组成的子数组的长度
                    int numLength = i - startIndexMap.get(num);
                    if (numLength < itemLength){
                        item = num;
                    }
                }
            }
            //记录元素当前下标 即结束下标
            currIndexMap.put(num, i);
        }
        return currIndexMap.get(item) - startIndexMap.get(item) + 1;
    }

}
