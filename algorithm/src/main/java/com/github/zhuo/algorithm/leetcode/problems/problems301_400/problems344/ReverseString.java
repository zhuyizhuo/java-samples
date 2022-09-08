package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems344;

/**
 * https://leetcode.cn/problems/reverse-string/submissions/
 * 反转字符串
 * 难度 简单
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 提示:
 *  1 <= s.length <= 10^5
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class ReverseString {

    public static void main(String[] args) {

    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 47.8 MB , 在所有 Java 提交中击败了 93.97% 的用户
     * 通过测试用例： 477 / 477
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}
