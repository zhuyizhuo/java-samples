package com.github.zhuo.algorithm.leetcode.problems1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 删除字符串中的所有相邻重复项
 * 难度 简单
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    /**
     * 分析题意 可用栈来实现
     *
     * 执行用时： 23 ms , 在所有 Java 提交中击败了 62.07% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 16.83% 的用户
     */
    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Deque<Character> deque = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == chars[i]){
                deque.pop();
            } else {
                deque.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
