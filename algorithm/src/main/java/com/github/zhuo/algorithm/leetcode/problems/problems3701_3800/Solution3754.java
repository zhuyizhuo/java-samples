package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 连接非零数字并乘以其数字和 I
 * easy
 */
public class Solution3754 {

    /**
     * beats 99.85%
     */
    public long sumAndMultiply(int n) {
        long x=0;
        long sum=0;
        long k=1;
        while(n>0){
            if(n%10!=0){
                x=k*(n%10)+x;
                k=k*10;
            }
            sum+=n%10;
            n=n/10;
        }
        return x*sum;
    }
}