package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1812;

/**
 * https://leetcode-cn.com/problems/determine-color-of-a-chessboard-square/
 * 判断国际象棋棋盘中一个格子的颜色
 * 难度 简单
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回  true，如果是黑色，请返回  false  。
 *
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 *
 * 8 白 黑 白 黑 白 黑 白 黑
 * 7 黑 白 黑 白 黑 白 黑 白
 * 6 白 黑 白 黑 白 黑 白 黑
 * 5 黑 白 黑 白 黑 白 黑 白
 * 4 白 黑 白 黑 白 黑 白 黑
 * 3 黑 白 黑 白 黑 白 黑 白
 * 2 白 黑 白 黑 白 黑 白 黑
 * 1 黑 白 黑 白 黑 白 黑 白
 *   a  b c  d  e f  g  h
 *
 * 示例 1：
 *
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 *
 * 示例 2：
 *
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 *
 * 输入：coordinates = "c7"
 * 输出：false
 *
 * 提示：
 *
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1"));
        System.out.println(squareIsWhite("h3"));
        System.out.println(squareIsWhite("c7"));
    }

    /**
     * 执行用时: 0 ms
     */
    public static boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        if (chars[0] == 'a'
            || chars[0] == 'c'|| chars[0] == 'e'|| chars[0] == 'g'){
            if (chars[1] % 2 == 1){
                return false;
            } else {
                return true;
            }
        } else {
            if (chars[1] % 2 == 1){
                return true;
            } else {
                return false;
            }
        }
    }
}
