package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems22;

import java.util.ArrayList;
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
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(4);
        System.out.println(strings.size());
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res =new ArrayList<>();
        StringBuilder currString =new StringBuilder();
        generateParenthesisHelp(res,currString,n,0,0);
        return res;

    }

    public void generateParenthesisHelp(List<String> res,StringBuilder currString,int n,int left,int right){
        if(right==n){  //此时必须要保证左括号比右括号先用完。终止条件也可以写currString.length() == 2 * n
            res.add(currString.toString());
            return;
        }

        if(left<n){  //不是n/2，因为n为括号对数
            currString.append("(");
            generateParenthesisHelp(res,currString,n,left+1,right);
            currString.deleteCharAt(currString.length() - 1); //这个回溯回溯的是上上行的，不是递归里的，递归里的操作在递归的这个位置也手动删除了
        }
        if(left>right){  //这里不应该再再条件里加left<n了，因为由于上一个，left不肯大于n，等于n时也可以加右括号
            currString.append(")");
            generateParenthesisHelp(res,currString,n,left,right+1);
            currString.deleteCharAt(currString.length() - 1); //这个回溯回溯的是上上行的，不是递归里的
        }
        return;
    }

}
