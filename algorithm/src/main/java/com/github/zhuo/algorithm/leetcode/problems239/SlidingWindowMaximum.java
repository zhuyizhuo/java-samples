package com.github.zhuo.algorithm.leetcode.problems239;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 滑动窗口最大值
 *
 * 难度: 困难
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
//        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, -6, 3, 6, 7}, 3);
        int[] ints = maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println();
    }

    /**
     * 思路：
     *  分析题意可知，将原数组分为K个一组，每组取最大元素，滑动窗口每次只向右移动一位。
     *  我们可以先在原数组中减去K个元素，看剩余多少个元素即可知滑动窗口可向右移动几次，加上第一组K个元素本身，
     *  即返回的数组元素个数为 nums.length - k + 1
     *
     *  模拟滑动窗口，取出其中的K个元素，将元素排序。取最大元素
     *  窗口向右滑动时，新增最右边的元素，移除最左边的元素，新增元素时一直保持K个元素的有序。取最大元素
     *  一直到窗口滑动至数组结束。
     *
     *  需要一种数据结构 满足: 可方便的新增删除指定元素,新增与删除时保持数据有序,能方便的获取最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1){
            return nums;
        }
        int length = nums.length;
        int newLength = length - k + 1;
        int[] resp = new int[newLength];
        int index = 0;
        MaximumMap maximumMap = new MaximumMap(nums, k);
        for (int i = 0; i < length; i++) {
            maximumMap.add(nums[i]);
            if (i >= k - 1){
                resp[index] = maximumMap.getMax();
                index++;
            }
        }
        return resp;
    }

    public static class MaximumMap extends TreeMap<Integer,Integer> {
        /** 数组 */
        private final int[] nums;
        /** 最大容量 */
        private final int total;
        /** 最左元素下标 */
        private int left = 0;
        /** 当前容量 */
        int count = 0;
        /** 最大元素 */
        Integer max;

        public MaximumMap(int[] nums, int total) {
            this.nums = nums;
            this.total = total;
        }

        public void add(int para){
            if(++count > total){
                //如果最左元素为最大元素，将最大元素置为空
                if (nums[left] == max){
                    max = null;
                }
                //FIXME 移除最左元素  此解法如果存在两个相同的参数，则会出现问题
                super.remove(nums[left]);
                //最左元素下标加一
                left++;
            }
            //如果新增元素大于最大元素 则给最大元素赋值
            if (max != null && max < para){
                max = para;
            }
            //放入新增元素
            super.put(para, para);
        }

        public int getMax(){
            //如果存在最大元素直接返回
            if (max != null){
                return max;
            }
            System.out.println("剩余元素:" + super.toString());
            //不存在最大元素则迭代Map取最大元素
            Set<Map.Entry<Integer, Integer>> entries = super.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                max = entry.getValue();
            }
            return max;
        }
    }
}
