package com.github.zhuo.algorithm.leetcode.problems1_100.problems59;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 螺旋矩阵 II
 * 难度 中等
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 提示：
 *
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int i = 0; i < ints.length; i++) {
            int length = ints[i].length;
            for (int j = 0; j < length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 思路  模拟逆时针旋转
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 49.29% 的用户
     */
    public static int[][] generateMatrix(int n) {
        int[][] resp = new int[n][n];
        int total = n * n;
        int row = 0;
        int col = -1;
        int count = 0;
        int begin = 0;
        int top = 1;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (count < total){
            while (col < right && count < total){
                resp[row][++col] = ++begin;
                count++;
            }
            right--;
            while (row < bottom && count < total){
                resp[++row][col] = ++begin;
                count++;
            }
            bottom--;
            while (col > left && count < total){
                resp[row][--col] = ++begin;
                count++;
            }
            left++;
            while (row > top && count < total){
                resp[--row][col] = ++begin;
                count++;
            }
            top++;
        }
        return resp;
    }
}
