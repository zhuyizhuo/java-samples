package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法实现
 * 稳定排序算法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class BubbleSort {
    
    /**
     * 冒泡排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        boolean swapped;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 内层循环进行相邻元素比较和交换
            // 每轮结束后，最大的元素会冒泡到数组末尾，所以每轮比较次数可以减少
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素大于下一个元素，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果一轮中没有发生交换，说明数组已经有序，提前结束排序
            if (!swapped) {
                break;
            }
        }
        
        return arr;
    }
    
    /**
     * 测试冒泡排序
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}