package com.github.zhuo.algorithm.leetcode.problems.problems700_800.problems766;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 *
 * 托普利茨矩阵
 *
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 提示:
 *  m == matrix.length
 *  n == matrix[i].length
 *  1 <= m, n <= 20
 *  0 <= matrix[i][j] <= 99
 *
 * TODO
 * 进阶:
 *  如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 *  如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * 示例1: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 *
 *  1 2 3 4
 *  5 1 2 3
 *  9 5 1 2
 *
 *  各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 示例2: matrix = [[1,2],[2,2]]
 *
 *  1 2
 *  2 2
 *  对角线 "[1, 2]" 上的元素不同。答案是 false
 *
 *  分析两个示例可知逆对角线的元素相同非托普利茨矩阵
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1,2},{2,1}}));
    }

    /**
     * 思路: 对角线元素相同即为true, 即从第二行起，每行的第二列至最后的元素等于上一行当前列数减一的元素值
     *
     * 考虑特殊情况 只有一行 和 只有一列 按题意应该为 true
     *
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int length = matrix.length;
        //只有一行直接返回 true
        if (length == 1){
            return true;
        }
        int itemLength = matrix[0].length;
        //只有一列直接返回true
        if (itemLength == 1){
            return true;
        }
        //从第二行起判断
        for (int i = 1; i < length; i++) {
            //每行的第二列
            for (int j = 1; j < itemLength; j++) {
                //和上一行的上一列错位相比，只要有一个元素不相等 直接返回 false
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
