package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 三个相等元素之间的最小距离 I
 * easy
 *
 * 给你一个整数数组 nums。
 *
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 *
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 *
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
 */
public class Solution3740 {

    /**
     * beats 100%
     */
    public int minimumDistance(int[] nums) {
        boolean[] list=new boolean[nums.length];
        int add1=0,add2=0,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(!list[i]){
                list[i]=true;
                add1=i;
                int times=0;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]==nums[i]) {
                        list[j]=true;
                        times++;
                        if(times==1){
                            add2=j;
                            continue;
                        }else if(times%2==0){
                            min=Math.min(j-add1,min);
                            add1=j;
                        }else if(times%2==1){
                            min=Math.min(j-add2,min);
                            add2=j;
                        }
                    }
                }
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        else return 2*min;
    }
}