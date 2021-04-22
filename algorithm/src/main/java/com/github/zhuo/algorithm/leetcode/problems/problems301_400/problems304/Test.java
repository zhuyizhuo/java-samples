package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems304;

public class Test {

    public static void main(String[] args) {
        NumMatrixSolution numMatrixSolution = new NumMatrixSolution(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrixSolution.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrixSolution.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrixSolution.sumRegion(1, 2, 2, 4));
    }
}
