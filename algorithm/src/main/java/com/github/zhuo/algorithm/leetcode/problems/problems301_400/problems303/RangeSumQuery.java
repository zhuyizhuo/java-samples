package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems303;

public class RangeSumQuery {

    public static void main(String[] args) {
        NumArraySecond second = new NumArraySecond(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(second.sumRange(1, 2));
        System.out.println(second.sumRange(0, 5));
        System.out.println(second.sumRange(1, 3));
        System.out.println(second.sumRange(3, 5));
        System.out.println(second.sumRange(2, 6));
    }

}
