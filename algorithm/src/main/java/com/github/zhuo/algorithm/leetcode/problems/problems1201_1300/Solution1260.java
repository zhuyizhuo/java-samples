package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300;

import java.util.Arrays;
import java.util.List;

/**
 * 二维网格迁移
 * easy
 */
public class Solution1260 {

    /**
     * beats 100%
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int l=m*n;
        int idx=(-k%l+l)%(l);
        int[][]a=new int[m][n];
        for(int i=idx;i<idx+l;i++) {
            a[(i-idx)/n][(i-idx)%n]=grid[i%l/n][i%l%n];
        }
        List ans= Arrays.asList(a);
        return ans;
    }
}