package com.github.zhuo.algorithm.leetcode.problems.problems601_700.problems667;

/**
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 * 优美的排列 II
 * 难度 中等
 *
 * 1 <= k < n <= 10^4
 */
public class BeautifulArrangementII {

    public static void main(String[] args) {
        int[] ints = constructArray(3, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 52.75% 的用户
     * 通过测试用例： 70 / 70
     */
    public static int[] constructArray(int n, int k) {
        int[] rtn = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            rtn[index] = i;
            ++index;
        }
        for (int i = n-k, j = n; i <= j; i++, j--) {
            rtn[index] = i;
            ++index;
            if (i != j){
                rtn[index] = j;
                ++index;
            }
        }
        return rtn;
    }
}
