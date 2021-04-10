package com.github.zhuo.algorithm.leetcode.problems.problems200_300.problems227;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * 基本计算器 II
 * 难度 中等
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 提示：
 *   1 <= s.length <= 3 * 10^5
 *   s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 *   s 表示一个 有效表达式
 *   表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 *   题目数据保证答案是一个 32-bit 整数
 *
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(calculate("1 * 13 + 4 + 50/2 + 1 -2"));
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("2147483647"));
        System.out.println(calculate("5 "));
        System.out.println(calculate("2*3*4"));
        System.out.println(calculate("2 * 3 /4*  2"));
    }

    /**
     * 分析 这题可以用栈来计算  先算乘除 再算加减
     *
     * 需考虑运算过程中数据超过 int 最大值的情况
     * 因为是有效表达式  所以不会出现数字中间有空格的情况，例如 1 2 + 2，故不考虑此种情况
     *
     * 执行用时： 20 ms , 在所有 Java 提交中击败了 30.44% 的用户
     * 内存消耗： 50.7 MB , 在所有 Java 提交中击败了 10.03% 的用户
     */
    public static int calculate(String s) {
        Deque<String> stack = new LinkedList();
        int start = 0;
        //先算乘除
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //到了表达式结尾 将最后一个数入栈
            if (i == s.length() - 1){
                String substring = s.substring(start).trim();
                if (!"".equals(substring)){
                    stack.push(substring);
                }
            }
            if (c == ' '){
                continue;
            }
            if (c == '*'){
                String substring = s.substring(start, i).trim();
                if ("".equals(substring)){
                    substring = stack.pop();
                }
                long l = Long.parseLong(substring);
                long number = 0;
                for (start = i+1; start < s.length(); start++) {
                    if (s.charAt(start) == ' '){
                        continue;
                    }
                    if (!Character.isDigit(s.charAt(start))){
                        break;
                    }
                    number = number * 10 + Character.getNumericValue(s.charAt(start));
                }
                stack.push(String.valueOf(l * number));
                if (start == s.length() - 1){
                    break;
                }
                continue;
            } else if(c == '/'){
                String substring = s.substring(start, i).trim();
                if ("".equals(substring)){
                    substring = stack.pop();
                }
                long l = Long.parseLong(substring);
                long number = 0;
                for (start = i + 1; start < s.length(); start++) {
                    if (s.charAt(start) == ' '){
                        continue;
                    }
                    if (!Character.isDigit(s.charAt(start))){
                        break;
                    }
                    number = number * 10 + Character.getNumericValue(s.charAt(start));
                }
                stack.push(String.valueOf(l / number));
                if (start == s.length() - 1){
                    break;
                }
                continue;
            } else if (c == '+' || c == '-'){
                // + - 数字  如果是 + - ,把之前的数字入栈，并且把符号入栈
                String substring = s.substring(start, i).trim();
                if (!"".equals(substring)){
                    stack.push(substring);
                }
                stack.push(String.valueOf(c));
                start = i + 1;
                continue;
            }
        }
        //再算加减
        long result = 0;
        while (!stack.isEmpty()){
            String s1 = stack.pollLast();
            switch (s1){
                case "+":
                    result += Long.parseLong(stack.pollLast());
                    break;
                case "-":
                    result -= Long.parseLong(stack.pollLast());
                    break;
                default:
                    result = Long.parseLong(s1);
                    break;
            }
        }
        return (int)result;
    }

}