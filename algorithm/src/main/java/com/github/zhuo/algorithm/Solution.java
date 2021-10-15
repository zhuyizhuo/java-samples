package com.github.zhuo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{1,1, 2,3,1,1,2}, 9));
    }

    public static List<Integer> getMaxSum(int[] orderMoney, int target) {
        Arrays.sort(orderMoney);
        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        dfs(orderMoney, resp, inner, 0);
        int max = Integer.MIN_VALUE;
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < resp.size(); i++) {
            int total = 0;
            for (int j = 0; j < resp.get(i).size(); j++) {
                total += resp.get(i).get(j);
                if (total > target){
                    break;
                }
            }
            if (total <= target && total > max){
                max = total;
                order = resp.get(i);
            }
        }
        return order;
    }

    private static void dfs(int[] nums, List<List<Integer>> resp, List<Integer> index, int i) {
        resp.add(new ArrayList<>(index));
        if (i == nums.length){
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]){
                continue;
            }
            index.add(j);
            dfs(nums, resp, index, j + 1);
            index.remove(index.size() -  1);
        }
    }
}
