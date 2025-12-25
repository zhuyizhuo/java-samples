package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

import java.util.Arrays;

public class Solution3075 {

    public static void main(String[] args) {

    }

    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        int i=n-1,turn=0;
        long sum=0;
        while(turn<k&&i>=0){
            if(happiness[i]-turn<=0){
                break;
            }
            sum+=happiness[i]-turn;
            i--;
            turn++;
        }
        return sum;
    }}
