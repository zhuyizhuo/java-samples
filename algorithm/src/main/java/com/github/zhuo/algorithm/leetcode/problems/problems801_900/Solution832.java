package com.github.zhuo.algorithm.leetcode.problems.problems801_900;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 *  翻转图像
 *
 *  难度 简单
 *
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2：
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 *  提示：
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class Solution832 {

    public static void main(String[] args) {
        int[][] ints = flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            for (int j = 0; j < anInt.length; j++) {
                System.out.print(anInt[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 此题较简单 直接上代码
     *
     * 执行用时: 0 ms
     * 内存消耗: 38.9 MB
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        int itemLength = A[0].length;
        int[][] resp = new int[length][itemLength];
        for (int i = 0; i < length; i++) {
            //翻转每行 从后向前读取
            int index = 0;
            for (int j = itemLength - 1; j >= 0; j--) {
                resp[i][index] = 1 - A[i][j];
                index++;
            }
        }
        return resp;
    }
}
