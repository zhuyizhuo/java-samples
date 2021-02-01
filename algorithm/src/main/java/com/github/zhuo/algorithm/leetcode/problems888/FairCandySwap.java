package com.github.zhuo.algorithm.leetcode.problems888;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 *
 * 公平的糖果棒交换
 *
 * 交换两个数组中的一个数字 保证数组中所有数字之和相等
 */
public class FairCandySwap {

    public static void main(String[] args) {
        System.out.println(fairCandySwap(new int[]{1,1}, new int[]{2,2}));
    }

    /**
     * 思路分析:
     *  要保证和相等 首先要知道两个数组各自的和 及两个数组总和的差值
     *
     *  由于该题目保证一定有解，所以肯定存在两个值满足如下公式：
     *  2 * (A[i] - B[j]) = A-B 差值
     *  或
     *  2 * (B[j] - A[i]) = B-A 差值
     *
     *  即
     *  A[i] = AB差值/2 + B[j]
     *  或
     *  A[i] = B[j] - BA差值/2
     *
     *  可参考两数之和 解答该题。
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        Map<Integer, Integer> m = new HashMap<>();
        int lengthA = A.length;
        for (int i = 0; i < lengthA; i++) {
            sumA += A[i];
            m.put(A[i], A[i]);
        }
        int sumB = 0;
        int lengthB = B.length;
        for (int j = 0; j < lengthB; j++) {
            sumB += B[j];
        }
        //AB差值
        int i1 = (sumA - sumB)/2;
        for (int j = 0; j < lengthB; j++) {
            Integer integer = m.get(i1 + B[j]);
            if (integer != null){
                return new int[]{integer, B[j]};
            }
        }
        return null;
    }
}
