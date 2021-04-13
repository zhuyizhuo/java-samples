package com.github.zhuo.algorithm.leetcode.problems.problems700_800.problems703;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * 数据流中的第 K 大元素
 */
public class KthLargestElementInAStream {

    public static void main(String[] args) {
        //TODO 待优化时间复杂度
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
