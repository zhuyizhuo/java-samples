package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 直接插入排序算法实现
 * 稳定排序算法
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class InsertionSort {
    
    /**
     * 插入排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        // 从第二个元素开始，向前比较并插入到合适的位置
        for (int i = 1; i < n; i++) {
            // 记录当前要插入的元素
            int current = arr[i];
            // 从已排序的序列的右边开始向左查找
            int j = i - 1;
            // 当找到大于current的元素时，将该元素右移
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 将current插入到正确的位置
            arr[j + 1] = current;
        }
        
        return arr;
    }
    
    /**
     * 测试插入排序
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}