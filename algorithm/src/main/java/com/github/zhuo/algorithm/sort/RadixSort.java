package com.github.zhuo.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序算法实现
 * 稳定排序算法
 * 时间复杂度：O(d*(n+r))，其中d是位数，r是基数
 * 空间复杂度：O(n+r)
 */
public class RadixSort {
    
    /**
     * 基数排序实现
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        // 找出数组中的最大值
        int max = Arrays.stream(arr).max().getAsInt();
        
        // 计算最大值的位数
        int maxDigits = 0;
        while (max > 0) {
            maxDigits++;
            max /= 10;
        }
        
        // 执行基数排序
        int exp = 1; // 当前处理的位数（1表示个位，10表示十位，以此类推）
        int[] output = new int[arr.length];
        int[] count = new int[10]; // 用于计数排序的计数数组
        
        // 从个位开始，对每一位进行计数排序
        for (int i = 0; i < maxDigits; i++) {
            // 重置计数数组
            Arrays.fill(count, 0);
            
            // 统计当前位上每个数字出现的次数
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / exp) % 10;
                count[digit]++;
            }
            
            // 计算累计计数（确定每个数字应该放置的位置）
            for (int j = 1; j < 10; j++) {
                count[j] += count[j - 1];
            }
            
            // 从后向前遍历原数组，保证排序的稳定性
            for (int j = arr.length - 1; j >= 0; j--) {
                int digit = (arr[j] / exp) % 10;
                output[count[digit] - 1] = arr[j];
                count[digit]--;
            }
            
            // 将排序后的结果复制回原数组
            System.arraycopy(output, 0, arr, 0, arr.length);
            
            // 处理下一位
            exp *= 10;
        }
        
        return arr;
    }
    
    /**
     * 测试基数排序
     */
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}