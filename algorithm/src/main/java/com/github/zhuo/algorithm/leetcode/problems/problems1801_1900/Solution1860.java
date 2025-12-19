package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

//增长的内存泄露

/**
 * https://leetcode-cn.com/problems/incremental-memory-leak/
 * 增长的内存泄露
 * 难度 中等
 *
 * 给你两个整数 memory1 和 memory2 分别表示两个内存条剩余可用内存的位数。现在有一个程序每秒递增的速度消耗着内存。
 *
 * 在第 i 秒（秒数从 1 开始），有 i 位内存被分配到 剩余内存较多 的内存条（如果两者一样多，则分配到第一个内存条）。
 * 如果两者剩余内存都不足 i 位，那么程序将 意外退出 。
 *
 * 请你返回一个数组，包含 [crashTime, memory1crash, memory2crash] ，其中 crashTime是程序意外退出的时间（单位为秒），
 * memory1crash 和 memory2crash 分别是两个内存条最后剩余内存的位数。
 *
 * 提示：
 *
 *  0 <= memory1, memory2 <= 2^31 - 1
 */
public class Solution1860 {

    public static void main(String[] args) {
//        int[] ints = memLeak(2, 2);
        int[] ints = memLeak(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] memLeak(int memory1, int memory2) {
        int[] resp = new int[3];
        for (int i = 0;; i++) {
            if (memory1 >= memory2){
                if (memory1 < i){
                    resp[0] = i;
                    resp[1] = memory1;
                    resp[2] = memory2;
                    return resp;
                }
                memory1 -= i;
            } else {
                if (memory2 < i){
                    resp[0] = i;
                    resp[1] = memory1;
                    resp[2] = memory2;
                    return resp;
                }
                memory2 -= i;
            }
        }
    }
}