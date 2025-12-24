package com.github.zhuo.algorithm.leetcode.problems.problems801_900;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 * 单调数列
 * 难度 简单
 * 
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 */
public class Solution896 {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,1,2,1}));
        System.out.println(isMonotonic(new int[]{1,1,2,3}));
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
        System.out.println(isMonotonic(new int[]{6,6,4,7}));
        System.out.println(isMonotonic(new int[]{11,11,11,11}));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 15.95% 的用户
     */
    public static boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length == 1){
            return true;
        }
        // 根据开始两个数判断是增还是减
        boolean lessThan = A[0] < A[1];
        // 考虑到相等的话判断不出来，又声明一个来判断是否相等
        boolean lastIsEqual = A[0] == A[1];
        for (int i = 1; i < length - 1; i++) {
            //如果两数相等 直接下一个
            if (A[i] == A[i+1]){
                continue;
            }
            //当前两数不等才能走到这里，判断如果之前一直都是相等，需给增减标识赋值
            if (lastIsEqual){
                lessThan = A[i] < A[i+1];
                //从这开始就不是相等的了
                lastIsEqual = false;
                continue;
            }
            //两个数不相等，之前已经判断出是递增还是递减了 直接用当前的增减比对之前的增减，不同则说明不单调
            if ((A[i] < A[i+1]) != lessThan){
                return false;
            }
        }
        return true;
    }
}
