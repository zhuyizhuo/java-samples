package com.github.zhuo.algorithm.leetcode.problems.problems2501_2600;

/**
 * 分割数组中数字的数位
 *
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 *
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 *
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
 */
public class Solution2553 {

    /**
     * beats 93.38%
     */
    public int[] separateDigits(int[] nums) {
        int totalLength = 0;
        for (int num : nums) {
            totalLength += getLength(num);
        }
        int[] answer = new int[totalLength];
        int index = 0;
        for (int num : nums) {
            int start = index;
            int temp = num;
            while (temp != 0) {
                answer[index] = temp % 10;
                index++;
                temp /= 10;
            }
            reverse(answer, start, index - 1);
        }
        return answer;
    }

    public int getLength(int num) {
        int length = 0;
        while (num != 0) {
            length++;
            num /= 10;
        }
        return length;
    }

    public void reverse(int[] answer, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }
    }
}