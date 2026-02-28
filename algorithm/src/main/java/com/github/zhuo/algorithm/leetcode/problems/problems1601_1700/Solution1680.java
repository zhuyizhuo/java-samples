package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

/**
 * 连接连续二进制数字
 *
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 */
public class Solution1680 {

    /**
     * beats 98.84%
     */
    public int concatenatedBinary(int n) {
        int bi = 0;
        long res = 0;
        final long MOD = (long)(1e9 + 7);
        for(int i=1;i<=n;i++){
            if((i&(i-1)) == 0) bi++;
            res = ((res << bi)+i)%MOD;
        }
        return (int)res;
    }
}
