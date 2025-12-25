package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 最普通的解法
 */
public class Solution703 {
    private List<Integer> numsList;
    private int k;

    public Solution703(int k, int[] nums) {
        this.k = k;
        this.numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            this.numsList.add(nums[i]);
        }
    }

    public int add(int val) {
        numsList.add(val);
        Collections.sort(numsList);
        return numsList.get(numsList.size() - k);
    }

    public static void main(String[] args) {
        //TODO 待优化时间复杂度
        Solution703 kthLargest = new Solution703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
