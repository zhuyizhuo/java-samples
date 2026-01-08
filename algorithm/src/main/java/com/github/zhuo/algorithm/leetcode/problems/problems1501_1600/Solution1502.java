package com.github.zhuo.algorithm.leetcode.problems.problems1501_1600;

import java.util.Arrays;

public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * beats 100%
     */
    public boolean canMakeArithmeticProgression1(int[] arr) {
        int n =arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<n ;i++){
            if(max<arr[i]){
                max =arr[i];
            }
            if(min > arr[i]){
                min =arr[i];
            }
        }
        if(max == min){
            return true;
        }
        int dif = max-min;
        if(dif % (n-1) !=0){
            return false;
        }
        int per = dif / (n-1);
        boolean[] hasOccured = new boolean[arr.length];
        for(int i :arr){
            if(( i-min ) % per !=0){
                return false;
            }
            int position = (i - min) / per;
            if(hasOccured[position]) {
                return false;
            }
            hasOccured[position] = true;
        }
        return true;
    }
}