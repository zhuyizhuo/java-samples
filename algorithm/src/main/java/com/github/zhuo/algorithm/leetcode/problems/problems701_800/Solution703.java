package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class Solution703 {
    private List<Integer> numsList;
    private int k;

    /**
     * 最普通的解法
     */
    public Solution703(int k, int[] nums) {
        this.k = k;
        this.numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            this.numsList.add(nums[i]);
        }
    }

    public int add(int val) {
        numsList.add(val);
        Collections.sort(numsList);
        return numsList.get(numsList.size() - k);
    }

    public static void main(String[] args) {
        Solution703 kthLargest = new Solution703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

}

/**
 * 21ms beats 69.92%
 */
class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
    int max;
    public KthLargest(int k, int[] nums) {
        max = k;
        for (int num : nums) {
            heap.add(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > max) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * 16ms beats 99.67%
 */
class KthLargest1 {
    private int k;
    private int[] heap; // 最小堆
    private int size;

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k];
        this.size = 0;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(size < k){
            heap[size] = val;
            siftUp(size++);
        }else if(val > heap[0]){
            heap[0] = val;
            siftDown(0);
        }
        return heap[0];
    }
    private void siftUp(int i) {
        int p = (i - 1) >> 1;
        while (p >= 0){
            if (heap[i] < heap[p]){
                swap(i,p);
                i = p;
                p = (i - 1) >> 1;
            }else {
                break;
            }
        }
    }



    private void siftDown(int i) {
        int ls = 2 * i + 1;
        int rs = ls + 1;
        while (ls < size){
            int mins = ls;
            if(rs < size){
                mins = heap[ls] < heap[rs] ? ls : rs;
            }
            int minP = Math.min(heap[mins], heap[i]);
            if (minP == heap[i]){
                break;
            }else {
                swap(i,mins);
                i = mins;
                ls = 2 * mins + 1;
                rs = 2* mins + 2;
            }
        }
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}