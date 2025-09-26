package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序算法实现
 * 不稳定排序算法
 * 时间复杂度：O(nlogn) - O(n²)
 * 空间复杂度：O(logn)
 */
public class QuickSort {
    
    /**
     * 快速排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        quickSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }
    
    /**
     * 递归实现快速排序
     * @param arr 数组
     * @param low 起始索引
     * @param high 结束索引
     */
    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点
            int pivotIndex = partition(arr, low, high);
            
            // 递归排序分区点左右两边的子数组
            quickSortRecursive(arr, low, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 分区操作，选择最后一个元素作为基准值
     * @param arr 数组
     * @param low 起始索引
     * @param high 结束索引
     * @return 基准值的最终位置
     */
    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准值
        int pivot = arr[high];
        // i表示小于基准值的元素应该放置的位置
        int i = low - 1;
        
        // 遍历区间内的元素，将小于基准值的元素移到左侧
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // 将基准值放到正确的位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // 返回基准值的索引
        return i + 1;
    }
    
    /**
     * 测试快速排序
     */
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}