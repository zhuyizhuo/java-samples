package com.github.zhuo.algorithm.demo;

public class Search {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int k = 5;
        searchK(arr, arr.length, k);
    }

    /**
     * @param arr integer 数组
     * @param n 数组长度
     * @param k 要查找的值
     */
    public static int searchK(int arr[], int n, int k){
        for (int i = 0; i < n; i++) {
            if (arr[i] == k)
                return 1;
        }
        return 0;
    }
}
