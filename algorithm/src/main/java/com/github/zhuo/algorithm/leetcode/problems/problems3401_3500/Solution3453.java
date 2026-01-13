package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

/**
 * 给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
 *
 * 找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
 *
 * 答案如果与实际答案的误差在 10-5 以内，将视为正确答案。
 *
 * 注意：正方形 可能会 重叠。重叠区域应该被 多次计数 。
 */
public class Solution3453 {

    /**
     * beats 100%
     */
    public double separateSquares(int[][] squares) {
        // 二分，求最小的整数y，满足 2*area_y>=area
        int maxY = 0;
        long totalArea = 0;
        for (int[] square : squares) {
            maxY = Math.max(maxY, square[1] + square[2]);
            totalArea += (long)square[2] * square[2];
        }
        int l = 0;
        int r = maxY;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if(2 * calArea(squares, m) >= totalArea) {
                r = m;
            } else {
                l = m;
            }
        }
        // 答案在 r 和 r-1之间
        int y = r;
        long areaY = calArea(squares, y);
        long sumL = areaY - calArea(squares, y-1);
        return y - (2*areaY - totalArea)/(2.0*sumL);
    }

    private long calArea(int[][] squares,int m) {
        long area = 0;
        for (int[] square : squares) {
            int y = square[1];
            long l = square[2];
            if(y < m){
                area+= l * Math.min(m-y, l);
            }
        }
        return area;
    }
}