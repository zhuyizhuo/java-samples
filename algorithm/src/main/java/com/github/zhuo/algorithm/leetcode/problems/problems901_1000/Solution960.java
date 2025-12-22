package com.github.zhuo.algorithm.leetcode.problems.problems901_1000;

import java.util.Arrays;

/**
 * hard
 */
public class Solution960 {

    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] A) {
        int W = A[0].length();
        int[] dp = new int[W];
        Arrays.fill(dp, 1);
        for (int i = W-2; i >= 0; --i)
            search: for (int j = i+1; j < W; ++j) {
                for (String row: A)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

        int kept = 0;
        for (int x: dp)
            kept = Math.max(kept, x);
        return W - kept;
    }
}

/**
 * beats 100%
 */
class Solution {
    public char[][] charArrays;
    public int m,n;
    public int[] memo;
    public int dfs(int index){
        if(index >= n){
            return 0;
        }
        if(memo[index] != -1)return memo[index];
        int res = 0;
        // 选择当前点
        for(int i = index + 1; i < n; i++){
            boolean valid = true;
            for(int j = 0; j < m; j++){
                if(charArrays[j][i] < charArrays[j][index]){
                    valid = false;
                    break;
                }
            }
            if(valid){
                res = Math.max(res,1 + dfs(i));
            }
        }
        memo[index] = res;
        return res;
    }
    public int minDeletionSize(String[] strs) {
        m = strs.length;
        n = strs[0].length();
        charArrays = new char[m][n];
        for(int i = 0; i < m; i++){
            charArrays[i] = strs[i].toCharArray();
        }
        memo = new int[n];
        Arrays.fill(memo,-1);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res,n - (1 + dfs(i)));
        }
        return res;
    }
}