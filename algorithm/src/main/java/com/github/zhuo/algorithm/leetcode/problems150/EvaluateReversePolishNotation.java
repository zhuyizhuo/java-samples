package com.github.zhuo.algorithm.leetcode.problems150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 89.25% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 68.54% 的用户
     */
    public static int evalRPN(String[] tokens) {
        int length = tokens.length;
        if (length == 1){
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < length; i++) {
            String token = tokens[i];
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer pop = stack.pop();
                    Integer pop1 = stack.pop();
                    stack.push(pop1 - pop);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
