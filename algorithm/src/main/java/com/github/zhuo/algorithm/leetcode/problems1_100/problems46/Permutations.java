package com.github.zhuo.algorithm.leetcode.problems1_100.problems46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * 全排列
 */
public class Permutations {

    public static void main(String[] args) {
        //todo 需温习 直至掌握
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        List<Integer> list = new ArrayList<>();;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        deep(len, list, response, 0);
        return response;
    }

    private static void deep(int len, List<Integer> list, List<List<Integer>> response, int start) {
        if (start == len){
            response.add(new ArrayList<>(list));
        }
        for (int i = start; i < len; i++) {
            Collections.swap(list, i, start);
            deep(len, list, response, start + 1);
            Collections.swap(list, i, start);
        }
    }

}
