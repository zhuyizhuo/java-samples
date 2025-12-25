package com.github.zhuo.algorithm.leetcode.problems.problems601_700;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * 非递减数列
 *
 * 难度：简单
 * 
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 */
public class Solution665 {

    public static void main(String[] args) {
        //TODO 了解此题的其他解决办法
        System.out.println(checkPossibility(new int[]{3,7,2,3,4}));//false

        System.out.println(checkPossibility(new int[]{3,4,2,3}));//false

        System.out.println(checkPossibility(new int[]{3,7,9,3}));//true 3 7 9 10

        System.out.println(checkPossibility(new int[]{6,7,1,9}));//true 6 7 8 9

        System.out.println(checkPossibility(new int[]{5,7,1,8}));//true 5 7 8 8

        System.out.println(checkPossibility(new int[]{9,5,1,8}));//false

        System.out.println(checkPossibility(new int[]{0,9,1,2,3}));//true 0 1 2 3

        System.out.println(checkPossibility(new int[]{4,9,6,7,8}));//true 4 5 6 7 8

        System.out.println(checkPossibility(new int[]{0,4,2,3,1}));//false
    }

    /**
     * 一开始小看了这个题。
     *
     * 思路:
     * 此题看似简单 实则有很多特殊情况需要考虑。下次处理类似题型的时候可先列出各种情况的数组。仔细分析每种情况再作答。
     *
     * 本题的解决是从最简单的思路开始，试错+调整。说一下踩坑及完善的思路
     *
     *  1、首先根据题意可知  最多改变 1 个元素将数列变为非递减数列, 我们可以定义尝试次数为1,循环数组,
     *    如果当前值比下一个值大，则减去尝试次数，继续循环，如果仍然存在当前值比下一个值大，
     *    即尝试次数少于1次的时候，返回失败。
     *
     *   提交的时候未通过。反例 3,7,2,3,4。 分析反例，可知此种思路未考虑上一个值也大于下一个值的情况
     *
     *  2、增加逻辑判断 如果当前值非第一个值，拿当前值之前的值与下一个值比对，如果之前的值也大于下一个值 则返回失败。
     *  提交未通过。 反例 3,7,9,3。 6,7,1,9。 5,7,1,8。 6,7,1,8,9。
     *  分析反例可知，此种做法又走了另一个极端，将能转换一次通过的数列变为不可通过。
     *
     *  3、由以上逻辑的反例，可知不能直接返回失败。
     *  于是修改逻辑为 如果当前值非第一个值,将下一个值设置为当前值, 然后重新循环一遍。
     *  如果还存在相邻两值，前者大于后者的情况，就返回失败。
     *
     *  反例 0,9,1,2,3。 4,9,6,7,8。
     *  分析反例可知，如果当前值是要变更的值的话，逻辑有误。
     *
     *  4、修改逻辑 最终逻辑如下:
     *
     *  定义尝试次数为1,循环数组,如果当前值比下一个值大，判断是否有尝试次数，没有尝试次数直接返回失败。
     *  如果有尝试次数，则减去尝试次数，且判断
     *      a.当前值为第一个值,将当前值设置为下一个值。
     *      b.当前值非第一个值,判断上一个值和下一值的大小,
     *          1.如果上一个值大于下一个值，将下一个值设置为当前值。 处理下一个值为可转换的值的情况。
     *          2.如果上一个值小于下一个值，将当前值设置为上一个值。 处理当前值为可转换的值的情况。
     *  然后重新循环一遍数组。如果仍存在相邻两数前者大于后者的情况，则返回失败。否则返回成功。
     *
     */
    public static boolean checkPossibility(int[] nums) {
        int count = 1;
        int len=nums.length;
        for (int i = 0; i < len - 1; i++) {
            // 如果当前数大于下一个数
            if (nums[i] > nums[i+1]){
                if (count < 1){
                    return false;
                } else {
                    count--;
                    if (i > 0){
                        if (nums[i-1] > nums[i+1]){
                            nums[i + 1] = nums[i];
                        } else {
                            nums[i] = nums[i-1];
                        }
                    } else {
                        nums[i] = nums[i+1];
                    }
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            // 如果当前数大于下一个数
            if (nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
