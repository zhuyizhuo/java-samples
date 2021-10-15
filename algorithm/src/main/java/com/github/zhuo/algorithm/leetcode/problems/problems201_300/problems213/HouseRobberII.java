package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems213;

public class HouseRobberII {

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{2,3,2}));
//        System.out.println(rob(new int[]{1,2,3,1}));
//        System.out.println(rob(new int[]{0}));
        System.out.println(rob(new int[]{1}));
        //预期 103
        System.out.println(rob(new int[]{1,3,1,3,100}));
    }

    /**
     * 草率了。
     */
    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int sum0 = 0;
        int sum1 = nums[0];
        //从第一个房子到倒数第二个房子
        for (int i = 0; i < nums.length - 1; i++) {

        }
        //从第二个房子到最后一个房子
        for (int i = 1; i < nums.length; i++) {

        }
        return -1;
    }
}
