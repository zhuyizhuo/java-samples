package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序算法实现
 * 稳定排序算法
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {
    
    /**
     * 归并排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        // 创建一个临时数组用于合并过程
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
        return arr;
    }
    
    /**
     * 递归实现归并排序
     * @param arr 原数组
     * @param temp 临时数组
     * @param left 左边界
     * @param right 右边界
     */
    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            // 计算中间点
            int mid = left + (right - left) / 2;
            
            // 递归排序左半部分
            mergeSortRecursive(arr, temp, left, mid);
            // 递归排序右半部分
            mergeSortRecursive(arr, temp, mid + 1, right);
            
            // 合并两个有序子数组
            merge(arr, temp, left, mid, right);
        }
    }
    
    /**
     * 合并两个有序子数组
     * @param arr 原数组
     * @param temp 临时数组
     * @param left 左边界
     * @param mid 中间点
     * @param right 右边界
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // 复制数组到临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;      // 左子数组的起始索引
        int j = mid + 1;   // 右子数组的起始索引
        int k = left;      // 原数组当前位置
        
        // 合并两个子数组
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        
        // 处理剩余的元素
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        // 右子数组的剩余元素已经在正确的位置上，不需要复制
    }
    
    /**
     * 测试归并排序
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}