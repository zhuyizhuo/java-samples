package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

/**
 * 获取单值网格的最小操作数
 *
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 *
 * 单值网格 是全部元素都相等的网格。
 *
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1
 */
public class Solution2033 {

    private static class Arr {
        int[] arr = new int[8];
        int max = 0;

        void ensureCapacity(int minCapacity) {
            if (minCapacity > arr.length) {
                int[] newArr = new int[Math.max(minCapacity, arr.length + arr.length / 2)];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                arr = newArr;
            }
        }

        void add(int index) {
            max = Math.max(max, index);
            ensureCapacity(index + 1);
            arr[index]++;
        }
    }

    /**
     * beats 100%
     */
    public int minOperations(int[][] grid, int x) {
        int remain = grid[0][0] % x;
        Arr arr = new Arr();
        for (int[] line : grid) {
            for (int num : line) {
                if (num % x == remain) {
                    arr.add(num / x);
                } else {
                    return -1;
                }
            }
        }
        int[] array = arr.arr;
        int mid = (grid.length * grid[0].length + 1) / 2;
        int temp = 0;
        for (int i = 0; i <= arr.max; i++) {
            temp += array[i];
            if (temp >= mid) {
                mid = i;
                temp = 0;
                break;
            }
        }
        for (int i = 0; i <= arr.max; i++) {
            temp += array[i] * Math.abs(i - mid);
        }
        return temp;
    }
}