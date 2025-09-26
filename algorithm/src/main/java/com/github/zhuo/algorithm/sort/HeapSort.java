package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序算法实现
 * 不稳定排序算法
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class HeapSort {
    
    /**
     * 堆排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        
        // 构建最大堆（从最后一个非叶子节点开始向上调整）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // 一个个从堆顶取出元素
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶（最大值）移到数组末尾
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // 重新调整堆结构
            heapify(arr, i, 0);
        }
        
        return arr;
    }
    
    /**
     * 调整堆的方法
     * @param arr 数组
     * @param n 堆的大小
     * @param i 需要调整的节点索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大值为根节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点
        
        // 如果左子节点大于根节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // 如果右子节点大于当前最大值
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // 如果最大值不是根节点
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // 递归地调整受影响的子树
            heapify(arr, n, largest);
        }
    }
    
    /**
     * 测试堆排序
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}