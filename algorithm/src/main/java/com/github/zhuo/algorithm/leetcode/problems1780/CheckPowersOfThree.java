package com.github.zhuo.algorithm.leetcode.problems1780;

/**
 * https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 *
 * 判断一个数字是否可以表示成三的幂的和
 * 难度 中等
 *
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3^x ，我们称这个整数 y 是三的幂。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 3^1 + 3^2
 *
 * 示例 2：
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 3^0 + 3^2 + 3^4
 *
 * 示例 3：
 * 输入：n = 21
 * 输出：false
 *
 * 提示：
 *   1 <= n <= 10^7
 */
public class CheckPowersOfThree {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
    }

    /**
     * 转为 3进制数 判断每位上的数字, 如果出现某一位为2则不满足题意(若干个不同的三的幂之和)。
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.4 MB , 在所有 Java 提交中击败了 32.68% 的用户
     */
    public static boolean checkPowersOfThree(int n) {
        while (n != 0){
            if (n%3 == 2) return false;
            n = n/3;
        }
        return true;
    }
}
