package com.github.zhuo.algorithm.weekly;

public class MaximumDistanceBetweenAPairOfValues {

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println(maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println(maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println(maxDistance(new int[]{5,4}, new int[]{3,2}));
    }

    //下标对中的最大距离
    public static int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + max; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]){
                    max = Math.max(max, j - i);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
