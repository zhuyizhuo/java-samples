package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 搜索二维矩阵
 * 难度 中等
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class Solution74 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 30));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 33));
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 27.61% 的用户
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            if (target < matrix[i][0]){
                if (i == 0){
                    break;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i-1][j] == target){
                        return true;
                    }
                }
            } else if (i == length - 1){
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
