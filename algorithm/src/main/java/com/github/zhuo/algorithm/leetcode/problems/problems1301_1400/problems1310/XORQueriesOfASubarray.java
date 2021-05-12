package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400.problems1310;

/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 * 子数组异或查询
 * 难度 中等
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 提示：
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 *
 */
public class XORQueriesOfASubarray {

    public static void main(String[] args) {
//        int[] x = xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}});
        int[] x = xorQueries(new int[]{4,8,2,10}, new int[][]{{2,3},{1,3},{0,0},{0,3}});
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 49.2 MB , 在所有 Java 提交中击败了 55.60% 的用户
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] all = new int[arr.length];
        all[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            all[i] = all[i-1] ^ arr[i];
        }
        int[] resp = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0){
                resp[i] = all[queries[i][1]];
            } else {
                resp[i] = all[queries[i][0] - 1] ^ all[queries[i][1]];
            }
        }
        return resp;
    }
}
