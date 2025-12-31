package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 难度 中等
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Solution54 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{23,24,25,26}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3}}));
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 57.48% 的用户
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length;
        int right = matrix[0].length;
        int total = bottom * right;
        int top = 0;
        int left = 0;
        //当前行
        int row = 0;
        //当前列的下标
        int index = 0;
        List<Integer> resp = new ArrayList<>();
        while (resp.size() < total){
            //向右
            while (index < right && resp.size() < total){
                resp.add(matrix[row][index]);
                index++;
            }
            index--;
            right--;
            row++;
            //向下
            while (row < bottom && resp.size() < total){
                resp.add(matrix[row][index]);
                row++;
            }
            row--;
            bottom--;
            index--;
            //向左
            while (index >= left && resp.size() < total){
                resp.add(matrix[row][index]);
                index--;
            }
            index++;
            left++;
            row--;
            //向上
            while (row > top && resp.size() < total){
                resp.add(matrix[row][index]);
                row--;
            }
            top++;
            row++;
            index++;
        }
        return resp;
    }
}
