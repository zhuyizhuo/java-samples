package com.github.zhuo.algorithm.leetcode.interview.interview17_21;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 *
 * 直方图的水量
 * 难度 困难
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        List<Integer> leftList = new ArrayList<>();
        int left = 0;
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= left || i == height.length - 1){
                left = height[i];
                if (sum != 0){
                    leftList.add(sum);
                    sum = 0;
                }
                continue;
            }
            sum += height[left] - height[i];
        }
        return 0;
    }
}
