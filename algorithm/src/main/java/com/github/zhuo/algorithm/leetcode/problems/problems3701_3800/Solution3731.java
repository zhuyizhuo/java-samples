package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出缺失的元素
 */
public class Solution3731 {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //min,max
        //shuzu
        int min = 100;int max = 0;
        boolean[] f = new boolean[101];
        for(int x:nums){
            f[x] = true;
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        for(int i = min+1;i<max;i++){
            if(!f[i]) res.add(i);
        }
        return res;


    }
}