package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotating-the-box/
 * 旋转盒子
 * 难度 中等
 *
 * 给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 *
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 * 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，
 * 另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
 *
 * 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 *
 * 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。
 *
 * 提示：
 *
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j] 只可能是 '#' ，'*' 或者 '.' 。
 *
 */
public class Solution1861 {

    public static void main(String[] args) {
//        char[][] chars = rotateTheBox(new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}});
//        char[][] chars = rotateTheBox(new char[][]{{'#', '.', '#'}});
        char[][] chars = rotateTheBox(new char[][]{{'#','#','*','.','*','.'}, {'#','#','#','*','.','.'}, {'#','#','#','.','#','.'}});
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        char[][] resp = new char[box[0].length][box.length];
        for (int i = 0; i < resp.length; i++) {
            Arrays.fill(resp[i],'.');
        }
        //原盒子宽 即 新盒子高
        for (int boxWidth = box[0].length - 1; boxWidth >= 0; boxWidth--) {
            // 原盒子高 即 新盒子宽
            for (int boxDeep = box.length - 1; boxDeep >= 0; boxDeep--) {
                //新盒子的当前高度 = 原盒子的当前宽度
                int deep = boxWidth;
                // 因为是旋转90度 所以原盒子最高的 为新盒子宽度最靠前的
                // 所以新盒子的当前宽度 = 原盒子的总高度 - 1 - 原盒子当前高度
                int width = box.length - 1 - boxDeep;
                if (box[boxDeep][boxWidth] == '.' || box[boxDeep][boxWidth] == '*'){
                    resp[deep][width] = box[boxDeep][boxWidth];
                } else if (box[boxDeep][boxWidth] == '#'){
                    for (int k = deep; k < box[0].length; k++) {
                        if (resp[k][width] == '*' || resp[k][width] == '#'){
                            resp[k-1][width] = '#';
                            break;
                        }
                        if (k == box[0].length - 1){
                            resp[k][width] = '#';
                        }
                    }
                }
            }
        }
        return resp;
    }
}
