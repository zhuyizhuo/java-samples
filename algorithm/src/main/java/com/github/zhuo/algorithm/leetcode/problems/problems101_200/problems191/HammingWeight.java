package com.github.zhuo.algorithm.leetcode.problems.problems101_200.problems191;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        System.out.println(hammingWeight(-3));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.76% 的用户
     * 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 27.28% 的用户
     */
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
