package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 简单选择排序算法实现
 * 不稳定排序算法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class SelectionSort {
    
    /**
     * 选择排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        // 遍历整个数组
        for (int i = 0; i < n - 1; i++) {
            // 假设当前索引的元素是最小的
            int minIndex = i;
            // 在未排序部分寻找最小元素的索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果找到比当前元素更小的元素，则交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        
        return arr;
    }
    
    /**
     * 测试选择排序
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}