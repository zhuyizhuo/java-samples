package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 整数的镜像距离
 *
 * 给你一个整数 n。
 *
 * 定义它的 镜像距离 为：abs(n - reverse(n))，其中 reverse(n) 表示将 n 的数字反转后形成的整数。
 *
 * 返回表示 n 的镜像距离的整数。
 *
 * 其中，abs(x) 表示 x 的绝对值。
 */
public class Solution3783 {

    /**
     * beats 100%
     */
    public int mirrorDistance(int n) {
        //存储，然后转为数组增添就好了
        int tmp=n;
        int reverse=0;
        while(tmp!=0){
            reverse*=10;
            reverse+=tmp%10;
            tmp/=10;
        }
        return n-reverse>0?n-reverse:reverse-n;
    }
}