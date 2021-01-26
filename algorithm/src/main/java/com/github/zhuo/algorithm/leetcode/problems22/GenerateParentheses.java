package com.github.zhuo.algorithm.leetcode.problems22;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * 括号生成
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
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        //TODO
    }

    public List<String> generateParenthesis(int n) {
        String parentheses = "()";
        List<String> parenthesesList = new ArrayList<>();
        if (n == 1){
            parenthesesList.add(parentheses);
            return parenthesesList;
        }
        return null;
    }

}
