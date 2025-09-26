package com.github.zhuo.algorithm.leetcode.problems.problems901_1000.problems989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 *
 * 2021-01-22 21:49:34 每日一题
 * 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 */
public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
//        int[] nums = new int[]{9,9,9,9,9,9,9,9,9,9};
//        List<Integer> integers = addToArrayForm(nums, 1);
        int[] nums = new int[]{1};
        List<Integer> integers = addToArrayForm(nums, 8999);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    /**
     * 题目数组长度在 1至10000 之间 所以此题不能用简单的累加计算
     * 思路为 从个位数相加 看是否有进位，
     * 1、需考虑到数组结束，数字未累加完成，及数字加完，数组未循环完成。
     * 2、需考虑到数组和数字皆结束，还有进位 需补在最前边
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        boolean carry = false;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int i1;
            if (K != 0){
                i1 = K % 10 + A[i];
                K = K / 10;
            } else {
                i1 = A[i];
            }
            if (carry){
                i1 += 1;
            }
            if (i1 >= 10){
                carry = true;
                A[i] = i1 - 10;
            } else {
                carry = false;
                A[i] = i1;
            }
            list.push(A[i]);
        }
        while (K != 0){
            int i1 = K % 10;
            K = K / 10;
            if (carry){
                i1 += 1;
            }
            if (i1 >= 10){
                carry = true;
                list.push(i1 - 10);
            } else {
                carry = false;
                list.push(i1);
            }
        }
        if (carry){
            list.push(1);
        }
        return list;
    }

}
