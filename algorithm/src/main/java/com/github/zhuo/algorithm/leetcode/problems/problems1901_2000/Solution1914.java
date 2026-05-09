package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

/**
 * 循环轮转矩阵
 */
public class Solution1914 {

    /**
     * beats 71.64%
     */
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ln = Math.min(m, n) / 2; // ln: layer number
        for (int i = 0; i < ln; i++) {
            int[] data = new int[(m - 2 * i) * (n - 2 * i)
                    - (m - (i + 1) * 2) * (n - (i + 1) * 2)];
            int idx = 0;
            // from left to right
            for (int j = i; j < n - i - 1; j++) {
                data[idx++] = grid[i][j];
            }
            // from top to bottom
            for (int j = i; j < m - i - 1; j++) {
                data[idx++] = grid[j][n - i - 1];
            }
            // from right to left
            for (int j = n - i - 1; j > i; j--) {
                data[idx++] = grid[m - i - 1][j];
            }
            //from bottom to top
            for (int j = m - i - 1; j > i; j--) {
                data[idx++] = grid[j][i];
            }

            // restore to grid from rotated array
            this.rotate(data, k);
            idx = 0;

            // from left to right
            for (int j = i; j < n - i - 1; j++) {
                grid[i][j] = data[idx++];
            }
            // from top to bottom
            for (int j = i; j < m - i - 1; j++) {
                grid[j][n - i - 1] = data[idx++];
            }
            // from right to left
            for (int j = n - i - 1; j > i; j--) {
                grid[m - i - 1][j] = data[idx++];
            }
            // from bottom to top
            for (int j = m - i - 1; j > i; j--) {
                grid[j][i] = data[idx++];
            }
        }

        return grid;
    }

    // 189. Rotate Array(Modified:"rotate the array to the right"
    // to "rotate the array to the left"
    private void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;

        k = k % n; // rotate k is equal to k % n
        this.reverse(nums, 0, n - 1);
        this.reverse(nums, 0, n - k - 1);
        this.reverse(nums, n - k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}