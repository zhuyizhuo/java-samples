package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800.problems1734;

/**
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 * 解码异或后的排列
 * 难度 中等
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 */
public class DecodeXORedPermutation {

    public static void main(String[] args) {
//        int[] decode = decode(new int[]{3, 1});
        int[] decode = decode(new int[]{6,5,4,6});
        for (int i = 0; i < decode.length; i++) {
            System.out.println(decode[i]);
        }
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 98.67% 的用户
     * 内存消耗： 59.5 MB , 在所有 Java 提交中击败了 96.67% 的用户
     */
    public static int[] decode(int[] encoded) {
        int length = encoded.length;
        int all = 0;
        for (int i = 1; i <= length+1; i++) {
            all ^= i;
        }
        for (int i = 1; i < length; i+=2) {
            all ^= encoded[i];
        }
        int[] resp = new int[length+1];
        resp[0] = all;
        for (int i = 0; i < length; i++) {
            all ^= encoded[i];
            resp[i+1] = all;
        }
        return resp;
    }
}
