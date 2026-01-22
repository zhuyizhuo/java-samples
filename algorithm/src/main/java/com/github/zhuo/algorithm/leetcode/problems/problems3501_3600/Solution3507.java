package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 移除最小数对使数组有序 I
 *
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 *
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 *
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 */
public class Solution3507 {
    /**
     * 3ms beats 55.74%
     */
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int count = 0;

        while (list.size() > 1) {
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);

                if (list.get(i) > list.get(i + 1)) {
                    isAscending = false;
                }

                if (sum < minSum) {
                    minSum = sum;
                    targetIndex = i;
                }
            }

            if (isAscending) {
                break;
            }

            count++;
            list.set(targetIndex, minSum);
            list.remove(targetIndex + 1);
        }
        return count;
    }
}

/**
 * 1ms beats 100%
 */
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int cnt=0;
        while(check(nums)){
            int n=nums.length-1,sum=nums[0]+nums[1],index=0;
            for(int i=1;i<n;i++){
                if(nums[i]+nums[i+1]<sum){
                    index=i;
                    sum=nums[i]+nums[i+1];
                }
            }
            nums[index++]=sum;
            cnt++;
            for(int i=index;i<n;i++){
                nums[i]=nums[i+1];
            }
            nums = Arrays.copyOf(nums,n);
        }
        return cnt;
    }
    private boolean check(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return true;
            }
        }
        return false;
    }
}