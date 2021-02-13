package com.github.zhuo.algorithm.leetcode.problems448;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * 找到所有数组中消失的数字
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    /**
     * 思路 原地修改数组
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            int real = (num - 1) % length;
            nums[real] += length;
        }
        List<Integer> resp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(nums[i] <= length){
                resp.add(i + 1);
            }
        }
        return resp;
    }
}
