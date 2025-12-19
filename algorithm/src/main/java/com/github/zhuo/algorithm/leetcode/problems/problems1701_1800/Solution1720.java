package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800;

/**
 * https://leetcode-cn.com/problems/decode-xored-array/
 * 解码异或后的数组
 *
 * 难度 简单
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * 提示：
 *  2 <= n <= 10^4
 *  encoded.length == n - 1
 *  0 <= encoded[i] <= 10^5
 *  0 <= first <= 10^5
 */
public class Solution1720 {

    public static void main(String[] args) {
//        int[] decode = decode(new int[]{1, 2, 3}, 1);
        int[] decode = decode(new int[]{6,2,7,3}, 4);
        for (int i = 0; i < decode.length; i++) {
            System.out.println(decode[i]);
        }
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 17.40% 的用户
     */
    public static int[] decode(int[] encoded, int first) {
        int[] resp = new int[encoded.length + 1];
        resp[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            resp[i+1] = encoded[i] ^ resp[i];
        }
        return resp;
    }
}
