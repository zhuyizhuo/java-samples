package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems22;

import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * 括号生成
 * 难度 中等
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * 提示
 *     1 <= n <= 8
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        //TODO
        List<String> strings = generateParenthesis(4);
        System.out.println(strings.size());
        System.out.println(strings);
    }

    /**
     *
     */
    public static List<String> generateParenthesis(int n) {

        return null;
    }

}
