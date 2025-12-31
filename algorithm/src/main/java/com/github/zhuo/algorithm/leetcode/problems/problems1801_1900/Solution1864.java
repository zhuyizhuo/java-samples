package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

public class Solution1864 {

    public static void main(String[] args) {
        //1
        System.out.println(minSwaps("111000"));
        //0
        System.out.println(minSwaps("010"));
        //-1
        System.out.println(minSwaps("1110"));
        //1
        System.out.println(minSwaps("100"));
        //1
        System.out.println(minSwaps("0010111"));
        //1010101
        System.out.println(minSwaps("1111000"));
        System.out.println(minSwaps("1111100"));
        System.out.println(minSwaps("1001001"));
    }

    public static int minSwaps(String s) {
        int n = s.length();
        int n0 = 0, n1 = 0;

        // 统计0和1的个数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                n0++;
            } else {
                n1++;
            }
        }

        int res = Integer.MAX_VALUE;

        // 尝试 "1010..." 模式（1开头）
        if (n1 == (n + 1) / 2 && n0 == n / 2) {
            int diff1 = 0;
            for (int i = 0; i < n; i++) {
                // 如果当前位置应该是1（偶数位置0,2,4...）但实际不是1，则需要交换
                if (s.charAt(i) - '0' == i % 2) {
                    diff1++;
                }
            }
            res = Math.min(res, diff1 / 2);
        }

        // 尝试 "0101..." 模式（0开头）
        if (n0 == (n + 1) / 2 && n1 == n / 2) {
            int diff2 = 0;
            for (int i = 0; i < n; i++) {
                // 如果当前位置应该是0（偶数位置0,2,4...）但实际不是0，则需要交换
                if (s.charAt(i) - '0' != i % 2) {
                    diff2++;
                }
            }
            res = Math.min(res, diff2 / 2);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
