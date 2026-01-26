package com.github.zhuo.algorithm.leetcode.problems.problems1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 * easy
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 每对元素对 [a,b] 如下：
 *
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 */
public class Solution1200 {
    /**
     * beats 99.89%
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int k = max - min + 1;
        boolean[] count = new boolean[k];
        for (int num : arr) {
            count[num - min] = true;
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!count[j]) j++;
            arr[i] = j++ + min;
        }
        List<List<Integer>> result = new ArrayList<>();
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int curDif = arr[i+1] - arr[i];
            if (curDif < dif) {
                result.clear();
                dif = curDif;
            }
            if (curDif == dif) result.add(Arrays.asList(arr[i], arr[i+1]));
        }
        return result;
    }
}