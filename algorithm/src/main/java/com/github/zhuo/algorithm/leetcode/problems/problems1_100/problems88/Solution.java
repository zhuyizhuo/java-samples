package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems88;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0){
            nums1 = Arrays.copyOf(nums2, n);
            return;
        }
        if (nums2.length == 0){
            return;
        }
        int nums2Index = n - 1;
        int nums1Index = m + n - 1;
//        while (){
//
//        }
    }
}
