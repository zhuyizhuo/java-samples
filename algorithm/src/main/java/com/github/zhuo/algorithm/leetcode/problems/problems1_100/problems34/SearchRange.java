package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems34;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {

    public static void main(String[] args) {

    }

    /**
     * 暴力算法 先解出来
     *
     * O(n) 时间复杂度
     */
    public int[] searchRange(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] == target){
                        return new int[]{i, j};
                    }
                }
                return new int[]{i, i};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * beats 100%
     */
    public int[] searchRange1(int[] nums, int target) {
        int length= nums.length;
        int l = 0,r=length-1;
        int[] tar = {-1,-1};
        //分批找，先找第一个位置。
        while (l<=r){
            int avg = (l+r)/2;
            if (nums[avg]==target&&(avg==0||nums[avg-1]<target)){
                tar[0]=avg;
                break;
            }else if (target<nums[avg]||nums[avg]==target){
                r=avg-1;
            }else {
                l=avg+1;
            }
        }

        //分批找，再找第二个位置。
        l = 0;
        r=length-1;
        while (l<=r){
            int avg = (l+r)/2;
            if (nums[avg]==target&&(avg==length-1||nums[avg+1]>target)){
                tar[1]=avg;
                break;
            }else if (target>nums[avg]||nums[avg]==target){
                l=avg+1;
            }else {
                r=avg-1;
            }
        }

        return tar;
    }
}
