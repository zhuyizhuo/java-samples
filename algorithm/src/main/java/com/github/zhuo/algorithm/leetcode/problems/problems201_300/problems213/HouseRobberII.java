package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems213;

/**
 * 打家劫舍 II
 * 难度 中等
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 */
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
