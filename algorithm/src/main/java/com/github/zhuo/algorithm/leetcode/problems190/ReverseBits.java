package com.github.zhuo.algorithm.leetcode.problems190;

public class ReverseBits {

    public static void main(String[] args) {
        String s = Integer.toBinaryString(5);
        System.out.println(s);
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

}
