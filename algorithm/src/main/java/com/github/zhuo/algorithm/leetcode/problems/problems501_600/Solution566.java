package com.github.zhuo.algorithm.leetcode.problems.problems501_600;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 * 重塑矩阵
 */
public class Solution566 {

    public static void main(String[] args) {
        int[][] x = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        //新数组的总数
        int total = r * c;
        //原矩阵行数
        int rowCount = nums.length;
        //新数组
        int[][] reshape = new int[r][c];
        //从第0行给新数组赋值
        int newRow = 0;
        //从第0列给新数组赋值
        int newLine = 0;
        //原矩阵总数  解此题的时候看了题目约束没说每个子数组是等长。 后续看官方题解 才知道"矩阵"原来就是默认每个子数组等长
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            int[] row = nums[i];
            for (int j = 0, lineCount = row.length; j < lineCount; j++) {
                //循环原数组的每个元素赋值给新的数组
                reshape[newRow][newLine] = nums[i][j];
                count++;
                // 列数下标增加
                newLine++;
                //如果列数下标大于给定的列数 则行数+1 列数归零
                if (newLine >= c){
                    newRow++;
                    newLine = 0;
                }
            }
        }
        //如果原数组总数小于给定的新数组的总数 返回原数组
        if (count < total){
            return nums;
        }
        //返回重排后的新数组
        return reshape;
    }
}
