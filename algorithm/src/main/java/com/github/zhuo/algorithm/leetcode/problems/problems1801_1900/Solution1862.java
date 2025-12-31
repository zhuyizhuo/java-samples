package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/problems/sum-of-floored-pairs/
 * 向下取整数对和
 * 难度 困难
 *
 *  给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。
 *  由于答案可能会很大，请你返回答案对10^9 + 7 取余 的结果。
 *
 * 函数 floor() 返回输入数字的整数部分。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class Solution1862 {

    public static void main(String[] args) {
//        System.out.println(sumOfFlooredPairs(new int[]{2,5,9}));
//        System.out.println(sumOfFlooredPairs(new int[]{7,7,7,7,7,7,7}));
    }

    public int sumOfFlooredPairs(int[] sum) {
        long res=0,p=1000000007;
        int n=sum.length,maxx=0;
        //找到最大的数，确定数组范围
        for(int i=0;i<n;i++){
            maxx=Math.max(maxx,sum[i]);
        }
        int[] num=new int[maxx+1];
        //计数
        for(int i=0;i<n;i++)
            num[ sum[i] ]++;
        //前缀和
        for(int i=1;i<=maxx;i++)
            num[i]+=num[i-1];
        for(int i=1;i<=maxx;i++){
            //x表示数字i的个数
            long x=num[i]-num[i-1];
            if(x==0)
                continue;
            //[i,i*2-1]、[i*2,i*3-1]、[i*3,i*4-1]，区间内的floor函数值都一样
            for(int j=i;j<=maxx;j=j+i){
                //y表示区间的个数,如果j+i-1>maxx则取maxx即可，防止数组溢出
                long y=num[Math.min(j+i-1,maxx)]-num[j-1];
                //倍数*区间数*个数
                res=(res+(j/i)*y*x)%p;
            }
        }
        return (int)res;
    }

}
