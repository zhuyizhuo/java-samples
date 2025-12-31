package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Solution6 {

    public static void main(String[] args) {
        System.out.println(convert("A", 1).equals("A"));
    }

    /**
     *  思路：
     *  分析题意，可知此题为字符串根据一定的规则重新组合。
     *  分析 Z 字形结构，可知字符串的下标是有一定的规律。
     *
     *  首行末行下标 起始下标 0, 下一个字符串下标为 起始下标 + 相差的下标，
     *  相差的下标 = 2 * numRows - 减去开始节点自身，减去拐角节点。
     *
     *  每向下移动一行，起始下标 + 1, 结束下标 - 1，所以相差下标为上一行的差值减去2个。
     *
     *  由于是竖着的反 Z 字形，在超过 3 行之后，
     *  观察图形可知，除去首行和末行为 Z 字形的顶点或转角，其他每行多出一个字符，且左右的下标差值不尽相同。
     *  每向下移动一行，左侧的下标差值在减少，右侧的下标差值为首行差值减去左侧差值。
     *
     *  分析不同的 numRows 和字符串对应的下标排列如下：
     *  numRows：3
     *  首行末行横向每两个下标之差 = 2 * numRows - 2 = 2 * 3 - 2 = 4
     *  第二行下标差值为 2
     *
     *  0,  4,  8,   12,   第0行 起始下标 0 相差 4 = 2 * 3 - 2
     *  1,3,5,7,9,11,13,   第1行 起始下标 1 相差 2 = 4 - 2
     *  2,  6,  10         第2行 起始下标 2 相差 4 = 首行 可处理为 相差 = 2 - 2 = 0 时 变为首行
     *
     *  numRows：4
     *  首行末行横向每两个下标之差 = 2 * numRows - 2 = 2 * 4 - 2 = 6
     *  第二行下标差值,第一个差值为 4 = 首行差值 - 2，第二个差值为 2,第三个差值为 4 和为首行差值。
     *  第三行下标差值,第一个差值为 2 = 首行差值 - 4，第二个差值为 4,第三个差值为 2。
     *  由图形分析可知，除去首末行，其他各行每两个差值的和等于首行坐标差值。
     *
     *  0,   6,     12,
     *  1  5,7,  11,13,
     *  2,4  8,10,  14,
     *  3    9,
     *
     *  numRows：5
     *  首行末行横向每两个下标之差 = 2 * numRows - 2 = 2 * 5 - 2 = 8
     *
     *  0,      8,        16,
     *  1     7,9,     15,17,
     *  2,  6,  10,  14,  18,
     *  3,5,    11,13,    19,
     *  4,      12,       20
     */
    public static String convert(String s, int numRows) {
        int length = s.length();
        //当字符串长度小于行数 或者行数小于等于1时, 无法进行 Z 字形转换,直接返回字符串
        if (length <= numRows || numRows <= 1){
            return s;
        }
        // 首行下标差值
        int firstDiff = 2 * numRows - 2;
        // 除去首行末行 其他每行的 左侧下标差值
        int leftDiff = firstDiff;
        // 除去首行末行 其他每行的 右侧下标差值
        int rightDiff = firstDiff;
        StringBuilder sb = new StringBuilder();
        int row = 0;
        int index = 0;
        boolean left = true;
        int lastRowNum = numRows - 1;
        while (row < numRows){
            sb.append(s.charAt(index));
            if (left){
                // 把下标指向下一个位置 = 当前下标 + 下标差值
                index += leftDiff;
                left = false;
            } else {
                index += rightDiff;
                left = true;
            }
            // 如果下标超过字符串长度, 则向下移动一行
            if (index >= length){
                row ++;
                //每次换行将起始下标归位
                index = row;
                left = true;
                //末行差值等于首行
                if (row == lastRowNum){
                    leftDiff = firstDiff;
                    rightDiff = firstDiff;
                } else {
                    //每次换行差值减去2
                    leftDiff -= 2;
                    rightDiff = firstDiff - leftDiff;
                }
                continue;
            }
        }
        return sb.toString();
    }
}
