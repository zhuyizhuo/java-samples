package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems338;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 比特位计数
 * 难度 中等
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *   输入: 2
 *   输出: [0,1,1]
 *
 * 示例 2:
 *   输入: 5
 *   输出: [0,1,1,2,1,2]
 *
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class CountingBits {

    public static void main(String[] args) {
        int[] x = countBits(2);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    /**
     * 不讲武德法  使用内置函数
     */
    public static int[] countBits(int num) {
        int[] resp = new int[num+1];
        for (int i = 0; i <= num; i++) {
            resp[i] = Integer.bitCount(i);;
        }
        return resp;
    }

    public static int[] countBits1(int num) {
        int[] resp = new int[num+1];
        for (int i = 0; i <= num; i++) {
            resp[i] = Integer.bitCount(i);;
        }
        return resp;
    }
}
