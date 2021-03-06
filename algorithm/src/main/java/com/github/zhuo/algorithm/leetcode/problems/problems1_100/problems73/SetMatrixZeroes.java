package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems73;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 矩阵置零
 * 难度 中等
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroesNew(matrix);
        for (int i = 0; i < matrix.length; i++) {
            int length = matrix[i].length;
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 19.60% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 20.72% 的用户
     */
    public static void setZeroes(int[][] matrix) {
        int length = matrix.length;
        int length1 = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 在上题解思路上优化，减少原数组循环次数
     */
    public static void setZeroesNew(int[][] matrix) {
        int length = matrix.length;
        int length1 = matrix[0].length;
        HashMap<Integer,Integer> rowMap = new HashMap<>();
        HashMap<Integer,Integer> colMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] == 0){
                    if (!rowMap.containsKey(i)){
                        rowMap.put(i, j);
                    }
                    if (!colMap.containsKey(j)){
                        colMap.put(j, i);
                    }
                } else if (rowMap.containsKey(i) || colMap.containsKey(j)){
                    //后续有包含需置为0的行列  则直接置为0
                    matrix[i][j] = 0;
                }
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : rowMap.entrySet()) {
            //将需置为0的行 该行之前的列置为0
            for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                matrix[integerIntegerEntry.getKey()][i] = 0;
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : colMap.entrySet()) {
            //将需置为0的列 该列之前的行置为0
            for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                matrix[i][integerIntegerEntry.getKey()] = 0;
            }
        }
    }

}
