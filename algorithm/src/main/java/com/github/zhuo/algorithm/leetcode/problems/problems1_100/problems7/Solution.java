package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems7;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }

    /**
     * 思路 转为 long 从后向前反转即可
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 95.21% 的用户
     */
    public static int reverse(int x) {
        long tmp = x;
        long result = 0L;
        while (tmp != 0){
            result =  result * 10 + tmp % 10;
            tmp = tmp/10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }

}
