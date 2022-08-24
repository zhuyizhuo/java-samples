package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500.problems1460;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/submissions/
 *  通过翻转子数组使两个数组相等
 *  难度 简单
 *
 */
public class CanBeEqual {

    public static void main(String[] args) {
        int[] target = new int[]{1,2,3,4};
        int[] arr = new int[]{2,4,1,3};
        System.out.println(canBeEqual(target, arr));
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 12.97% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 24.06% 的用户
     * 通过测试用例： 106 / 106
     */
    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : target) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            Integer integer = m.get(i);
            if (integer == null || integer == 0){
                return false;
            }
            int i1 = integer - 1;
            m.put(i, i1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value != 0){
                return false;
            }
        }
        return true;
    }

}
