package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 *
 * 示例 1：
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 *
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class Solution1351 {
    public int countNegatives(int[][] grid) {
        int num = 0;
        for (int[] row : grid) {
            for (int value : row) {
                if (value < 0) {
                    num++;
                }
            }
        }
        return num;
    }
}

/**
 * beats 100%
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;
            int firstNeg = cols; // default: no negatives

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[i][mid] < 0) {
                    firstNeg = mid;
                    right = mid - 1; // move left
                } else {
                    left = mid + 1;
                }
            }

            count += cols - firstNeg;
        }

        return count;
    }
}