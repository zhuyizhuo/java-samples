package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.HashMap;
import java.util.Map;

public class Solution1865 {

    private int[] nums2;
    private Map<Integer, Integer> nums1Map = new HashMap<>();
    private Map<Integer, Integer> nums2Map = new HashMap<>();

    public Solution1865(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        for (int i = 0; i < nums1.length; i++) {
            nums1Map.put(nums1[i], nums1Map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], nums2Map.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        Integer integer = nums2Map.get(nums2[index]);
        if (integer == 1){
            nums2Map.remove(nums2[index]);
        } else {
            nums2Map.put(nums2[index], integer - 1);
        }
        nums2[index] += val;
        nums2Map.put(nums2[index], nums2Map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int total = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : nums2Map.entrySet()) {
            Integer integer = nums1Map.get(tot - integerIntegerEntry.getKey());
            if (integer != null){
                total += integer * integerIntegerEntry.getValue();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new Solution1865(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3,2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }

}
