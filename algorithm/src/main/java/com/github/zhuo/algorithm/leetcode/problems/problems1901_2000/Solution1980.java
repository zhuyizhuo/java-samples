package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

/**
 * 找出不同的二进制字符串
 *
 * 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 */
public class Solution1980 {

    /**
     * beats 100%
     */
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        char[] cs = new char[n];
        for (int i = 0; i < nums.length; i ++) {
            cs[i] = (char) (nums[i].charAt(i) ^ 1);
        }
        return new String(cs);
    }
}
