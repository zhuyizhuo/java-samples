package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序算法实现
 * 不稳定排序算法
 * 时间复杂度：O(n^1.3) - O(n^2)
 * 空间复杂度：O(1)
 */
public class ShellSort {
    
    /**
     * 希尔排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        // 初始步长设置为数组长度的一半
        int gap = n / 2;
        
        // 逐渐减小步长直到为1
        while (gap > 0) {
            // 对每个子序列进行插入排序
            for (int i = gap; i < n; i++) {
                // 保存当前要插入的元素
                int temp = arr[i];
                int j = i;
                // 对间隔为gap的元素进行插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            // 减小步长
            gap /= 2;
        }
        
        return arr;
    }
    
    /**
     * 测试希尔排序
     */
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3, 78, 43, 23, 45, 19};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}