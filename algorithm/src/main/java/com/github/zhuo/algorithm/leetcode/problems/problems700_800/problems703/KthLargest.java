package com.github.zhuo.algorithm.leetcode.problems.problems700_800.problems703;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 最普通的解法
 */
public class KthLargest {
    private List<Integer> numsList;
    private int k;

    public KthLargest(int k, int[] nums) {
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
}
